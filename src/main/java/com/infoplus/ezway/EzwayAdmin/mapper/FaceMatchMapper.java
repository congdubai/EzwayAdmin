package com.infoplus.ezway.EzwayAdmin.mapper;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FaceMatchMapper {
    CommonDTO findByTransId(String transId);
}
