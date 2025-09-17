package com.infoplus.ezway.EzwayAdmin.exception;

import org.springframework.security.core.AuthenticationException;

public class LimitedAccessException extends AuthenticationException {
    public LimitedAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public LimitedAccessException(String msg) {
        super(msg);
    }
}
