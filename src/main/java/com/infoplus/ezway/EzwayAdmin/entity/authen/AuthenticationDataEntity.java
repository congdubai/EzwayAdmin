package com.infoplus.ezway.EzwayAdmin.entity.authen;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDataEntity {
    private String transId;
    private String custNo;//CIF
    private String custId;
    private String type;
    private Boolean choiceOne;
//    private String frontImage;
//    private String depthImage;
    private String ekycTransId;
    private String finalStatus;
    private String finalMessage;
    private Timestamp createDate;
    private Timestamp updateDate;
}
