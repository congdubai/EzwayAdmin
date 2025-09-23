package com.infoplus.ezway.EzwayAdmin.dto.auth;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import lombok.Data;

@Data
public class AuthDetailResponse extends BaseResponseDto {
    private CommonDTO data;
}
