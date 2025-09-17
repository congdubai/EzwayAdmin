package com.infoplus.ezway.EzwayAdmin.mapper;


import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<UserEntity> findUserByEmployeeId(String employeeId);

}
