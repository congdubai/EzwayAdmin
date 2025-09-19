package com.infoplus.ezway.EzwayAdmin.service;


import com.infoplus.ezway.EzwayAdmin.common.Constant;
import com.infoplus.ezway.EzwayAdmin.common.SessionUtil;
import com.infoplus.ezway.EzwayAdmin.definition.ErrorCode;
import com.infoplus.ezway.EzwayAdmin.dto.AuthenticationRequestDTO;
import com.infoplus.ezway.EzwayAdmin.dto.AuthenticationResponseDTO;
import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.RegisterRequestDTO;
import com.infoplus.ezway.EzwayAdmin.entity.Role;
import com.infoplus.ezway.EzwayAdmin.entity.Token;
import com.infoplus.ezway.EzwayAdmin.entity.TokenType;
import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import com.infoplus.ezway.EzwayAdmin.exception.LimitedAccessException;
import com.infoplus.ezway.EzwayAdmin.interceptor.JwtTokenUtil;
import com.infoplus.ezway.EzwayAdmin.mapper.TokenMapper;
import com.infoplus.ezway.EzwayAdmin.mapper.UserMapper;
import com.infoplus.ezway.EzwayAdmin.objectmapper.UserPojoMapper;
import com.infoplus.ezway.EzwayAdmin.utils.CookieUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserPojoMapper mapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserMapper userMapper;
    private final TokenMapper tokenMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final HttpServletResponse httpServletResponse;
    @Value("${application.security.jwt.cookie-auth.name}")
    private String nameAuth;

    @Value("${application.security.jwt.expiration}")
    private int timeAuth;

    public BaseResponseDto register(RegisterRequestDTO authRequest) {
        // Nếu chưa có user nào trong hệ thống -> cho phép tạo SYSTEM user đầu tiên
        if (userMapper.countAllUsers() == 0) {
            UserEntity systemUser = mapper.toEntity(authRequest);
            systemUser.setPassword(passwordEncoder.encode(authRequest.getPassword()));
            systemUser.setRole(Role.SYSTEM); // luôn là SYSTEM
            userMapper.insertNewUserV2(systemUser);

            String accessToken = jwtTokenUtil.generateToken(systemUser);
            String refreshToken = jwtTokenUtil.generateRefreshToken(systemUser);
            userMapper.findUserByEmployeeId(systemUser.getEmployeeId())
                    .ifPresent(u -> saveUserToken(u, accessToken, refreshToken));

            AuthenticationResponseDTO response = AuthenticationResponseDTO.builder()
                    .data(AuthenticationResponseDTO.TokenResponse.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshToken)
                            .build())
                    .build();
            return response;
        }

        // Ngược lại -> cần user đăng nhập để có quyền tạo user mới
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Role loginRole = ((UserEntity) auth.getPrincipal()).getRole();
        Role regisRole = Role.valueOf(authRequest.getRole());

        // Check quyền
        if (loginRole != Role.SYSTEM && loginRole.getLevel() >= regisRole.getLevel()) {
            return new BaseResponseDto(ErrorCode.E03.getCode(), ErrorCode.E03.getDesc());
        }

        // Check trùng employeeId
        UserEntity user = mapper.toEntity(authRequest);
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        Optional<UserEntity> existingUser = userMapper.findUserByEmployeeId(user.getEmployeeId());
        if (existingUser.isPresent()) {
            return new BaseResponseDto(ErrorCode.E05.getCode(), ErrorCode.E05.getDesc());
        }

        // Tạo user mới
        userMapper.insertNewUserV2(user);
        String accessToken = jwtTokenUtil.generateToken(user);
        String refreshToken = jwtTokenUtil.generateRefreshToken(user);
        userMapper.findUserByEmployeeId(user.getEmployeeId())
                .ifPresent(u -> saveUserToken(u, accessToken, refreshToken));

        AuthenticationResponseDTO response = AuthenticationResponseDTO.builder()
                .data(AuthenticationResponseDTO.TokenResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build())
                .build();

        return response;
    }

    /*
     * if user authenticated successfully then revoke old token
     * */
    public BaseResponseDto authenticate(AuthenticationRequestDTO authRequest) {
        UserEntity user;
        user = userMapper.findUserByEmployeeId(authRequest.getEmployeeId()).orElseThrow(() -> new UsernameNotFoundException(ErrorCode.E06.getDesc()));
        SessionUtil.setSessionAttribute(Constant.CUST_ID, user.getEmployeeId());
        if (user.isBanned()) {
            throw new LockedException(ErrorCode.E07.getDesc());
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmployeeId(), authRequest.getPassword()));
            String accessToken = jwtTokenUtil.generateToken(user);
            String refreshToken = jwtTokenUtil.generateRefreshToken(user);
            saveUserToken(user, accessToken, refreshToken);
            if (user.getVisit() > 0) {
                user.setVisit(0);
                userMapper.updateVisit(user);
            }
            AuthenticationResponseDTO response = AuthenticationResponseDTO.builder()
                    .data(AuthenticationResponseDTO.TokenResponse.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshToken).fullName(user.getFullName())
                            .role(user.getRole().name())
                            .userId(user.getEmployeeId())
                            .branch(user.getBranch()).build()).build();
            CookieUtils.setCookie(httpServletResponse, nameAuth, accessToken, timeAuth);
            return response;
        } catch (AuthenticationException ex) {
            log.error("AuthenticationException: ", ex);
            int prevVisit = user.getVisit();
            updateVisit(user, prevVisit + 1);
            if (prevVisit > 3) {
                userMapper.banUser(user);
                throw new LimitedAccessException(ErrorCode.E08.getDesc());
            }
            throw new BadCredentialsException(ex.getMessage());
        }
    }

    private void saveUserToken(UserEntity user, String accessTaken, String refreshToken) {
        Token token = Token.builder().userId(user.getId()).accessTaken(accessTaken).refreshToken(refreshToken).tokenType(TokenType.BEARER).expired(false).revoked(false).build();
        tokenMapper.insertNewToken(token);
    }

    private void updateVisit(UserEntity user, int visit) {
        user.setVisit(visit);
        userMapper.updateVisit(user);
    }

}
