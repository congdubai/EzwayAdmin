package com.infoplus.ezway.EzwayAdmin.common;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ErrGroupCode {
    E_00000("00000", "Success", "0000", "OK"),
    E_99999("99999", "Request Parameter Error", "4101", "FR Request Parameter Error"),
    E_01000("01000", "OCR Request Data Format Error", "4102", "FR PP Request Parameter Error"),
    E_02000("02000", "OCR Information Extraction Error", "2101", "Detected passport data seem not correct. Please try again."),
    E_02100("02100", "OCR Complex Check Digit Error", "2101", "Detected passport data seem not correct. Please try again."),
    E_02200("02200", "OCR Check Digit Error", "2101", "Detected passport data seem not correct. Please try again."),
    E_04000("04000", "OCR Internal Service Error", "4103", "FR system error"),
    E_20050("20050", "Check Service Name", "4103", "FR system error"),
    E_90010("90010", "Service Name error", "4103", "FR system error"),
    E_90002("90002", "Service call / response error", "4103", "FR system error"),
    E_90003("90003", "FRServer Calling Error", "4103", "FR system error"),
    E_11001("11001", "No Customer Number", "4104", "Unable to detect data."),
    E_11002("11002", "No Channel Division", "4104", "Unable to detect data."),
    E_11003("11003", "No Customer Name", "4104", "Unable to detect data."),
    E_11004("11004", "No Os Type", "4104", "Unable to detect data."),
    E_11005("11005", "No Timestamp", "4104", "Unable to detect data."),
    E_11006("11006", "No App version", "4104", "Unable to detect data."),
    E_11007("11007", "Image Error", "4104", "Unable to detect data."),
    E_11009("11009", "No Mask Usage Condition", "4104", "Unable to detect data."),
    E_11010("11010", "No Encryption Usage Condition", "4104", "Unable to detect data."),
    E_11011("11011", "No Encryption hash Data", "4104", "Unable to detect data."),
    E_11012("11012", "No Encryption Data", "4104", "Unable to detect data."),
    E_11085("11085", "No Dept Image", "4104", "Unable to detect data."),
    E_11088("11088", "Untact API Type error", "4104", "Unable to detect data."),
    E_11252("11252", "Encryption Error", "4104", "Unable to detect data."),
    E_11253("11253", "TOTP HASH Data Error", "4104", "Unable to detect data."),
    E_12000("12000", "Method Error", "4104", "Unable to detect data."),
    E_12001("12001", "Template Data Error", "4104", "Unable to detect data."),
    E_20001("20001", "No User Registered", "4104", "Unable to detect data."),
    E_40002("40002", "Image Extraction Error", "4104", "Unable to detect data."),
    E_20003("20003", "Face doesn’t match", "2102", "Unable to authentication data. Please try again"),
    E_20004("20004", "Spoofing Found", "2102", "Unable to authentication data. Please try again"),
    E_20007("20007", "Sunglass Found", "2102", "Unable to authentication data. Please try again"),
    E_20008("20008", "Mask Found", "2102", "Unable to authentication data. Please try again"),
    E_20009("20009", "Sunglass + Mask Found", "2102", "Unable to authentication data. Please try again"),
    E_20011("20011", "No Eyebrow (when using Mask)", "2102", "Unable to authentication data. Please try again"),
    E_20014("20014", "Object Attack found", "2102", "Unable to authentication data. Please try again"),
    E_20015("20015", "Eye Closed found", "2102", "Unable to authentication data. Please try again"),
    E_20033("20033", "No Passport match", "2102", "Unable to authentication data. Please try again"),
    E_20034("20034", "NID Number doesn’t match", "2102", "Unable to authentication data. Please try again"),
    E_20035("20035", "Driver license doesn’t match", "2102", "Unable to authentication data. Please try again"),
    E_20036("20036", "NID doesn’t match", "2102", "Unable to authentication data. Please try again"),
    E_20040("20040", "Face is too small", "2102", "Unable to authentication data. Please try again"),
    E_20041("20041", "Wrong Face position", "2102", "Unable to authentication data. Please try again"),
    E_20042("20042", "Grayscale image", "2102", "Unable to authentication data. Please try again"),
    E_20043("20043", "Blurred Image", "2102", "Unable to authentication data. Please try again"),
    E_20051("20051", "User Registered", "2102", "Unable to authentication data. Please try again"),
    E_20052("20052", "Required to register NID", "2102", "Unable to authentication data. Please try again"),
    E_40000("40000", "NO face found", "2102", "Unable to authentication data. Please try again"),
    E_40001("40001", "Face Recognition Failure", "2102", "Unable to authentication data. Please try again"),
    E_40030("40030", "Image Angle Error", "2102", "Unable to authentication data. Please try again"),
    E_80001("80001", "DB SELECT Error", "4105", "Database connection error."),
    E_80002("80002", "DB INSERT Error", "4105", "Database connection error."),
    E_80003("80003", "DB UPDATE Error", "4105", "Database connection error."),
    E_80004("80004", "DB DELETE Error", "4105", "Database connection error."),
    E_604("604", "Can Not Save Image", "", ""),

//    E_80004("80004", "DB DELETE Error", "4105", "Database connection error."),
    E_TOTP_DEC("E_TOTP_DEC", "TOTP decrypt fail.", "2201", "TOTP decrypt fail."),
    E_TOTP_ENC("E_TOTP_ENC", "TOTP encrypt fail.", "2202", "TOTP encrypt fail."),
    E_TOTP_LIB("E_TOTP_LIB", "Load lib TOTP fail", "2203", "Load lib TOTP fail."),

    E_OCR_400("E_OCR_400", "OCR error 400", "4001", "OCR system error."),
    E_OCR_401("E_OCR_401", "OCR error 401", "4001", "OCR system error."),
    E_OCR_403("E_OCR_403", "OCR error 403", "4001", "OCR system error."),
    E_OCR_404("E_OCR_404", "OCR error 404", "4001", "OCR system error."),
    E_OCR_405("E_OCR_405", "OCR error 405", "4001", "OCR system error."),
    E_OCR_408("E_OCR_408", "OCR error 408", "4001", "OCR system error."),
    E_OCR_413("E_OCR_413", "OCR error 413", "4001", "OCR system error."),
    E_OCR_500("E_OCR_500", "OCR error 500", "4001", "OCR system error."),
    E_OCR_507("E_OCR_507", "OCR error 507", "4001", "OCR system error."),
    E_OCR_512("E_OCR_512", "OCR error 512", "4001", "OCR system error."),
    E_OCR_600("E_OCR_600", "OCR error 600", "4001", "OCR system error."),
    E_OCR_604("E_OCR_604", "OCR error 604", "4001", "OCR system error."),

    E_OCR_I3("E_OCR_I3", "No front id card", "4002", "The First Image Does Not Contain Front Side of ID Card."),
    E_OCR_I4("E_OCR_I4", "No back id card", "4003", "The Second Image Does Not Contain Back Side of ID Card."),
    E_OCR_I5("E_OCR_I5", "", "2000", "ID Number Format Not Right"),
    E_OCR_I6("E_OCR_I6", "", "2000", "Date Of Birth Format Not Right"),
    E_OCR_I7("E_OCR_I7", "", "2000", "Issue Date Format Not Right"),
    E_OCR_I8("E_OCR_I8", "", "2000", "Expire Date Format Not Right"),
    E_OCR_I10("E_OCR_I10", "", "2000", "The Front Side Image Contains No Face"),

    E_OCR_F4("E_OCR_F4", "front_back_check", "4004", "Input Image Not Of The Same Card Type."),
    E_OCR_F5("E_OCR_F5", "expired_check", "4004", "Id Card Expired"),
    E_OCR_F6("E_OCR_F6", "field_pasted_over_check", "4004", "Fields Is Pasted Over"),
    E_OCR_F7("E_OCR_F7", "face_pasted_over_check", "4004", "Face Is Pasted Over"),
    E_OCR_F8("E_OCR_F8", "chip_not_same_type_check", "4004", "Front-Back Images Not Of A Same Chip ID Card"),

    E_OCR_L1("E_OCR_L1", "", "2001", "Error item L1"),
    E_OCR_L2("E_OCR_L2", "", "2001", "Error item L2"),
    E_OCR_L3("E_OCR_L3", "", "2001", "Error item L3"),
    E_OCR_L4("E_OCR_L4", "", "2001", "Error item L4"),
    E_OCR_L5("E_OCR_L5", "", "2001", "Error item L5"),
    E_OCR_L6("E_OCR_L6", "", "2001", "Error item L6"),
    E_OCR_L7("E_OCR_L7", "", "2001", "Error item L7"),
    E_OCR_L8("E_OCR_L8", "", "2001", "Error item L8"),
    E_OCR_L9("E_OCR_L9", "", "2001", "Error item L9"),
    E_OCR_L10("E_OCR_L10", "", "2001", "Error item L10"),
    E_OCR_L11("E_OCR_L11", "", "2001", "Error item L11"),
    E_OCR_L12("E_OCR_L12", "", "2001", "Error item L12"),
    E_OCR_L13("E_OCR_L13", "", "2001", "Error item L13"),
    E_OCR_L14("E_OCR_L14", "", "2001", "Error item L14"),
    E_OCR_L15("E_OCR_L15", "", "2001", "Error item L15"),
    E_OCR_L16("E_OCR_L16", "", "2001", "Error item L16"),

    E_OCR_NOT_VN_CARD("E_OCR_NOT_VN_CARD", "", "2001", "This is not VN id card"),

    E_C06_NOT_FOUND("E_C06_NOT_FOUND", "Not found C06 info by c06id", "2301", "Not found C06 info by c06id."),
    E_ORG_NOT_FOUND("E_ORG_NOT_FOUND", "Not found ekyc register by orgTransId", "2302", "Not found ekyc register by orgTransId."),
    E_FAIL("E_FAIL", "Fail", "1000", "Fail."),
    E_HOLD("E_HOLD", "Hold", "1068", "Hold."),
    E_SM_NOTFOUND("E_SM_NOTFOUND", "Notfound info for submit.", "2401", "Notfound info for submit."),
    E_SM_CHECKFAIL("E_SM_CHECKFAIL", "Check info fail.", "2402", "Check info fail ."),
    E_4000("4000", "No OCR data found", "", "No selfie data found");

    private final String code;
    private final String description;
    private final String groupCode;
    private final String groupCodeMessage;

    ErrGroupCode(String code, String description, String groupCode, String groupCodeMessage) {
        this.code = code;
        this.description = description;
        this.groupCode = groupCode;
        this.groupCodeMessage = groupCodeMessage;
    }

    private static final Map<String, ErrGroupCode> CODE_TO_GRCODE = new HashMap<>();

    static {
        for (ErrGroupCode errorCode : values()) {
            CODE_TO_GRCODE.put(errorCode.code, errorCode);
        }
    }

    public static ErrGroupCode codeToGroupCode(String systemCode) {
        return CODE_TO_GRCODE.getOrDefault(systemCode, E_99999);
    }
}
