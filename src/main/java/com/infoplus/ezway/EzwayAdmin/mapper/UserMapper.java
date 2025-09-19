package com.infoplus.ezway.EzwayAdmin.mapper;


import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<UserEntity> findUserByEmail(String email);

    Optional<UserEntity> findUserByEmployeeId(String employeeId);

    void insertNewUser(UserEntity user);

    void insertNewUserV2(UserEntity user);

    void updateVisit(UserEntity user);

    void banUser(UserEntity user);

    void unBannedUser(UserEntity user);

    void updateNewPassword(UserEntity user);

    @Select("SELECT COUNT(*) FROM tbl_user")
    long countAllUsers();
}
