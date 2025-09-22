package com.infoplus.ezway.EzwayAdmin.mapper;

import com.infoplus.ezway.EzwayAdmin.dto.Common1DTO;
import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthRequest;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationRequest;
import com.infoplus.ezway.EzwayAdmin.entity.RegistrationDataEntity;
import com.infoplus.ezway.EzwayAdmin.entity.authen.AuthenticationDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {
    long countAllAuthentication(@Param("request") AuthRequest request);

    List<AuthenticationDataEntity> selectAuthenticationData(@Param("request") AuthRequest request,
                                                            int startRow,
                                                            int endRow);
    Common1DTO findByTransId(String transId);
}
