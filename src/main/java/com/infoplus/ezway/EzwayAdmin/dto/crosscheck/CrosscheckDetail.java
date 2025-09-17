package com.infoplus.ezway.EzwayAdmin.dto.crosscheck;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CrosscheckDetail {

    //TBL_CROSSCHECK_LOG
    private Long crosscheckId;
    private String custNo;
    private String custId;
    private String orgTransid;
    private String c06Id;
    private String isMatchText;
    private String crosscheckCode;
    private String isLatest;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Timestamp createDate;
    private String vrfBitmap;


    //TBL_COMPARE_LOG
    private Long cpNfcSelfieId;// face-match ảnh selfie và ảnh nfc
    private String selfieImage;
    private String chipImage;
    private String cpNfcSelfieCode;

    //TBL_UNTAC_LOG
    private Long score;
    private String frCode;
    private String frMsg;
    private String ezCode;
    private String ezMsg;
    private String ezwayJsonResponse;

    //TBL_REG_DATA
    private String nation;

}
