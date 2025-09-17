package com.infoplus.ezway.EzwayAdmin.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SessionUtil {
    public static HttpServletRequest getCurrentRequest() {
        return (HttpServletRequest) RequestContextHolder
                .currentRequestAttributes()
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
    }

    public static void setSessionAttribute(String key, Object value) {
        HttpServletRequest request = getCurrentRequest();
        request.setAttribute(key, value);
    }

    public static Object getSessionAttribute(String key) {
        HttpServletRequest request = getCurrentRequest();
        return request.getAttribute(key);
    }
}
