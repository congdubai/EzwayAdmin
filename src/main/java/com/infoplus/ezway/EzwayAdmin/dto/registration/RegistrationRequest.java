package com.infoplus.ezway.EzwayAdmin.dto.registration;

import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import lombok.Data;

@Data
public class RegistrationRequest {
    private PagingDTO paging;
    private RegistrationSearchParam data;
}
