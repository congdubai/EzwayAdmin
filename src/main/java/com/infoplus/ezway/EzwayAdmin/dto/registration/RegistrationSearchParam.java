package com.infoplus.ezway.EzwayAdmin.dto.registration;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RegistrationSearchParam {
    private String transId;
    private String startCreateDate;
    private String endCreateDate;
}
