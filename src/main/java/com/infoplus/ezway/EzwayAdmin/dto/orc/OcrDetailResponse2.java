package com.infoplus.ezway.EzwayAdmin.dto.orc;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcrDetailResponse2 extends BaseResponseDto {
    private CommonDTO data2;
    private String idcardType;    // thêm
    private String frontImage;    // thêm
    private String backImage;     // thêm
    private String address;
    private String age;
    private String birthday;
    private String district;
    private String doctype;
    private String ethnicity;
    private String expiration;
    private String homeTown;
    private String idNo;
    private String issueAt;
    private String issueDate;
    private String fullName;
    private String country;
    private String province;
    private String religion;
    private String ward;
    private String sex;
    private Timestamp createDate;
    private Timestamp updateDate;
}
