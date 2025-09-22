package com.infoplus.ezway.EzwayAdmin.dto.auth;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.entity.RegistrationDataEntity;
import com.infoplus.ezway.EzwayAdmin.entity.authen.AuthenticationDataEntity;
import lombok.Data;

import java.util.List;

@Data
public class AuthResponse extends BaseResponseDto {
    private PagingDTO paging;
    private List<AuthenticationDataEntity> data;
}
