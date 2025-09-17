package com.infoplus.ezway.EzwayAdmin.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public static final String TRX_DATE_PATTERN = "yyyyMMdd";
    public static final String LOGBACK_DATE_PATTERN = "yyyy-MM-dd";
    public static final String REQUEST_ID = "REQUEST_ID";
    public static final String REQUEST_BODY = "REQUEST_BODY";
    public static final String TRANS_ID = "TRANS_ID";
    public static final String CUST_ID = "CUST_ID";
    public static final String CUST_NO = "CUST_NO";
    public static final String OCR_ID = "OCR_ID";
    public static final String RESPONSE_TIME_PATTERN = "yyyyMMdd hh:mm:ss";
    public static final String CROSSCHECK_ID = "CROSSCHECK_ID";
    public static final String NATION = "NATION";

    public static final String STT_Y = "Y";
    public static final String STT_N = "N";
    public static final String IDCARD_FRONT = "idcard_front";
    public static final String IDCARD_BACK = "idcard_back";
    public static final String IDCARD_ROI = "idcard_roi";
    public static final String EX_KEY_SET = "ex_key_set";
    public static final String FRONT_FACE = "front_face";
    public static final String DEPTH_IMG = "depth_image";
    public static final String COMPARE_FACE_NFC_SELFIE = "compare_face_nfc_selfie";
    public static final String COMPARE_FACE_NFC_ROI = "compare_face_nfc_roi";
    public static final String THREAD_POOL_LOG = "log-executor";
    public static final String THREAD_POOL_BUSINESS = "ekyc-business-executor";
    public static final String IS_12NO_ID_CARD = "is_12no_id_card";
    public static final String IS_CHIP_CARD = "is_chip_card";
    public static final String COMPARE_CHIP_PP_SELFIE = "compare_face_nfc_selfie";
    public static final String COMPARE_CHIP_PP_IMG_ROI = "compare_face_nfc_roi";

    @UtilityClass
    public static final class RequestStatus {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAIL = "FAIL";
    }

    @UtilityClass
    public static class IdType {
        public static final String CCCD_CHIP = "1";
        public static final String K_PASSPORT = "2";
        public static final String CCCD_BARCODE = "3";
        public static final String NEW_CMND = "4";
        public static final String OLD_CMND = "5";
        public static final String CC_CHIP = "6"; // new can cuoc
        public static final String UNKNOW = "99";
        public static final String WOORI_PASSPORT = "99_WRPP"; //woori passport
    }

    @UtilityClass
    public static class FinalStt {
        public static final int APPROVE = 1;
        public static final int REJECT = 2;
        public static final int HOLD = 3;
        public static final int NA = 4;

    }

    @UtilityClass
    public static class osType {
        public static final String WIN = "WIN";
        public static final String LUX = "LUX";
        public static final String IOS = "IOS";
        public static final String AND = "AND";
        public static final String OTC = "OTC";

    }

    @UtilityClass
    public static class Types {
        public static final String NEW = "NEW";
        public static final String RETRY = "RETRY";


    }

    @UtilityClass
    public static class serviceType {
        public static final String REG = "REG";
        public static final String AUT = "AUT";
        public static final String CRO = "CRO";
        public static final String CRO_NFC_SELFIE = "CRO_NFC_SELFIE";
        public static final String CRO_NFC_OCR = "CRO_NFC_OCR";

    }

    public static class Doctype{
        public static final String OLD = "OLD";// cmnd cũ 9 số, thẻ giấy
        public static final String NEW = "NEW";// cmnd mới 12 số, thẻ nhựa
        public static final String CCCD = "CCCD";// cccd cũ barcode không gắn chip 12 số
        public static final String CHIP = "CHIP";// cccd gắn chip 12 số
        public static final String CHIP_NEW = "CHIP NEW";// căn cước mới gắn chip 12 số
        public static final String PASSPORT = "P";
        public static final String OTHER_PASSPORT = "Other Passport";
    }

}
