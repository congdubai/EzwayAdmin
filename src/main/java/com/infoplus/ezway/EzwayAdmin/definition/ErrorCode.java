package com.infoplus.ezway.EzwayAdmin.definition;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS("0000", "Success"),
    UN_MATCH("1068", "The front selfie does not match the printed face ocr image"),
    RESOURCE_ACCESS("50000", "Could not establish a connection to FR Middleware"),
    UNEXPECTED_ERROR("5500", ""),
    E00("00", "Success"),
    E01("01", "System error.Please, get in touch with admin to process"),
    E02("02", "Authentication failed: Bad credentials"),
    E03("03", "Access denied"),
    E05("05", "Account is registered"),
    E06("06", "Account is not existing"),
    E07("07", "Account is locked. Please contact to admin to process"),
    E08("08", "Over 5 failed login attempts"),
    E09("09", "Invalid Host"),
    E10("10", "Invalid Pin"),
    E11("11", "Duplicated Password");
    private final String code;
    private final String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
