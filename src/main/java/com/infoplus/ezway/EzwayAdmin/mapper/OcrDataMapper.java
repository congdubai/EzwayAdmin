package com.infoplus.ezway.EzwayAdmin.mapper;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDataDto;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OcrDataMapper {
    CommonDTO findByTransId(String transId);
    OcrDataDto findByTransId2(String transId);
}
