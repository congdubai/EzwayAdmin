package com.infoplus.ezway.EzwayAdmin.exception;


import com.infoplus.ezway.EzwayAdmin.common.ErrGroupCode;

public class EkycBusinessException extends RuntimeException {
    private String errorCode;
    private String errorDetail;// thông tin lỗi bổ sung cho trace lỗi, không phải là giá trị error desc trả về SDK

    public EkycBusinessException(String message) {
        super(message);
    }

    public EkycBusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public EkycBusinessException(String errorCode, String message, String errorDetail) {
        super(message);
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }

    public EkycBusinessException(ErrGroupCode errGroupCode, String errorDetail) {
        super(errGroupCode.getGroupCodeMessage());
        this.errorCode = errGroupCode.getGroupCode();
        this.errorDetail = errorDetail;
    }

    public EkycBusinessException(ErrGroupCode errGroupCode) {
        super(errGroupCode.getGroupCodeMessage());
        this.errorCode = errGroupCode.getGroupCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDetail() {
        return errorDetail;
    }
}
