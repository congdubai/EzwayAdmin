package com.infoplus.ezway.EzwayAdmin.exception;

public class MinioConnectException extends RuntimeException {
    public MinioConnectException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MinioConnectException(Throwable cause) {
        super(cause);
    }
}
