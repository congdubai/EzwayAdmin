package com.infoplus.ezway.EzwayAdmin.dto;


import com.infoplus.ezway.EzwayAdmin.definition.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor

public class BaseResponseDto {
    private String resultCode = ErrorCode.E00.getCode();
    private String resultDesc = ErrorCode.E00.getDesc();

    public BaseResponseDto(String resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }
}
