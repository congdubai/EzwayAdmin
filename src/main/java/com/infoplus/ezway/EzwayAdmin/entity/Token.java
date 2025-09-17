package com.infoplus.ezway.EzwayAdmin.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Token {
    private Integer id;
    private String accessTaken;
    private String refreshToken;
    private TokenType tokenType;
    private boolean revoked;
    private boolean expired;
    private Integer userId;
}
