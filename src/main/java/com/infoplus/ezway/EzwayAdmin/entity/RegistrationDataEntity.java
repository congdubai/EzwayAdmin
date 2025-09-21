package com.infoplus.ezway.EzwayAdmin.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RegistrationDataEntity {
    private Long id;
    private String transId;
    private String type;          // was types
    private Timestamp createDate;
    private Timestamp updateDate;
    private String lastestRegistered;
    private Boolean reviewStatus;
    private String reviewMessage;
    private String finalStatus;
    private String finalMessage;
    private String isDeleted;        // 'Y'/'N'
    private Timestamp deletedDate;
    private Boolean isFinish;
    private String subType;
}
