package com.infoplus.ezway.EzwayAdmin.dto.crosscheck;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import lombok.Data;

@Data
public class CrosscheckDetailResponse extends BaseResponseDto {
    private CrosscheckDetail data;
}
