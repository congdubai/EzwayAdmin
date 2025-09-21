package com.infoplus.ezway.EzwayAdmin.dto.registration;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.entity.RegistrationDataEntity;
import lombok.Data;
import java.util.List;

@Data
public class RegistrationResponse extends BaseResponseDto {
    private PagingDTO paging;
    private List<RegistrationDataEntity> data;
}
