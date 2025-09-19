package com.infoplus.ezway.EzwayAdmin.objectmapper;


import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.RegisterRequestDTO;
import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPojoMapper extends AbstractMapper<UserEntity, RegisterRequestDTO> {
}
