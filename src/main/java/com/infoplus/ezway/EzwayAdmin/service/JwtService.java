package com.infoplus.ezway.EzwayAdmin.service;

import com.infoplus.ezway.EzwayAdmin.definition.ErrorCode;
import com.infoplus.ezway.EzwayAdmin.dto.AuthenticationResponseDTO;
import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.entity.Token;
import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import com.infoplus.ezway.EzwayAdmin.interceptor.JwtTokenUtil;
import com.infoplus.ezway.EzwayAdmin.mapper.TokenMapper;
import com.infoplus.ezway.EzwayAdmin.mapper.UserMapper;
import com.infoplus.ezway.EzwayAdmin.utils.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final TokenMapper tokenMapper;
    @Value("${application.security.jwt.cookie-auth.name}")
    private String nameAuth;
    private final UserMapper userMapper;



    public BaseResponseDto verifyToken(HttpServletRequest request) throws IOException {
        final String accessToken = CookieUtils.getCookie(request, nameAuth);

        if(accessToken ==null || accessToken.isEmpty()){
            throw new AccessDeniedException(ErrorCode.E03.getDesc());
        }
        final String employeeId = jwtTokenUtil.extractEmail(accessToken);

        UserEntity user = userMapper.findUserByEmployeeId(employeeId).orElseThrow(() -> new UsernameNotFoundException(ErrorCode.E06.getDesc()));
        Optional<Token> optionalToken = tokenMapper.findByToken(accessToken);
        boolean isTokenValid = optionalToken
                .map(token -> !token.isExpired() && !token.isRevoked())
                .orElse(false);
        if (jwtTokenUtil.isTokenValid(accessToken, user) && isTokenValid) {
            AuthenticationResponseDTO response = AuthenticationResponseDTO.builder().data(AuthenticationResponseDTO
                    .TokenResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(optionalToken.get().getRefreshToken())
                    .fullName(user.getFullName())
                    .userId(user.getEmployeeId())
                    .role(user.getRole().name())
                    .branch(user.getBranch()).build()).build();
            return response;
        }
        else {
            throw new AccessDeniedException(ErrorCode.E03.getDesc());
        }
    }

}
