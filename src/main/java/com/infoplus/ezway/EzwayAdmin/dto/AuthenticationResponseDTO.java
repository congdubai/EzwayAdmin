package com.infoplus.ezway.EzwayAdmin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationResponseDTO extends BaseResponseDto {
    private TokenResponse data;

    @Getter
    @Builder
    public static class TokenResponse {
        private String accessToken;
        private String refreshToken;
        private String fullName;
        private String role;
        private String branch;
        private String userId;
    }
}
