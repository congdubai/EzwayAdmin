package com.infoplus.ezway.EzwayAdmin.dto.auth;

import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationSearchParam;
import lombok.Data;

@Data
public class AuthRequest {
    private PagingDTO paging;
    private AuthSearch data;
}
