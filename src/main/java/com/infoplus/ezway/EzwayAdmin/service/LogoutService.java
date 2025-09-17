package com.infoplus.ezway.EzwayAdmin.service;

import com.infoplus.ezway.EzwayAdmin.definition.ErrorCode;
import com.infoplus.ezway.EzwayAdmin.entity.Token;
import com.infoplus.ezway.EzwayAdmin.mapper.TokenMapper;
import com.infoplus.ezway.EzwayAdmin.utils.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
    private final TokenMapper tokenMapper;
    @Value("${application.security.jwt.cookie-auth.name}")
    private String nameAuth;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String accessToken = CookieUtils.getCookie(request, nameAuth);

        if(accessToken ==null || accessToken.isEmpty()){
            throw new AccessDeniedException(ErrorCode.E03.getDesc());
        }


        Token storedToken = tokenMapper.findByToken(accessToken)
                .orElse(null);
        if (storedToken != null) {
            tokenMapper.revokedToken(storedToken);
            SecurityContextHolder.clearContext();
            CookieUtils.clearAuthCookie(response,nameAuth);
        }
    }
}
