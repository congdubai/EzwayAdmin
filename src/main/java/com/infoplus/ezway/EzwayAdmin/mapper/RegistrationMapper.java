package com.infoplus.ezway.EzwayAdmin.mapper;

import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationRequest;
import com.infoplus.ezway.EzwayAdmin.entity.RegistrationDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RegistrationMapper {
    long countAllRegistration(@Param("request") RegistrationRequest request);

    List<RegistrationDataEntity> selectRegistrationData(@Param("request")RegistrationRequest request,
                                                        int startRow,
                                                        int endRow);
}
