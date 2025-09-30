package com.infoplus.ezway.EzwayAdmin.dto.orc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcrDataDto {
    private String idcardType;    // thêm
    private String address;
//    private String age;
    private String birthday;
//    private String district;
    private String doctype;
//    private String ethnicity;
    private String expiration;
//    private String homeTown;
    private String idNo;
//    private String issueAt;
    private String issueDate;
    private String fullName;
    private String country;
//    private String province;
//    private String religion;
//    private String ward;
    private String sex;
    private Timestamp createDate;
    private Timestamp updateDate;
}
