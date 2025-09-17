package com.infoplus.ezway.EzwayAdmin.interceptor;

import com.infoplus.ezway.EzwayAdmin.common.Constant;
import com.infoplus.ezway.EzwayAdmin.common.SessionUtil;
import com.infoplus.ezway.EzwayAdmin.mapper.TokenMapper;
import com.infoplus.ezway.EzwayAdmin.utils.CookieUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final TokenMapper tokenMapper;
    private final Environment env;
    @Value("${application.security.jwt.cookie-auth.name}")
    private String nameAuth;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        // todo extract jwt from request header
        final String jwt = extractToken(request);
        if (StringUtils.isEmpty(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        // todo extract email from jwt
        final String email = jwtTokenUtil.extractEmail(jwt);
        SessionUtil.setSessionAttribute(Constant.CUST_ID, email);
        if (StringUtils.isNotEmpty(email) && SecurityContextHolder.getContext().getAuthentication() == null) {
            // todo check user within database
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            boolean isTokenValid = tokenMapper.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);

            if (jwtTokenUtil.isTokenValid(jwt, userDetails) && isTokenValid) {
                // todo update SecurityContext
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        jwt,     // set token as a credential
                        userDetails.getAuthorities()
                );
                log.info(userDetails.getAuthorities().toString());
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {

        final String bearerToken = CookieUtils.getCookie(request, nameAuth);
        if (StringUtils.isNotEmpty(bearerToken)) {
            return bearerToken;
        }
        return StringUtils.EMPTY;
    }

}
