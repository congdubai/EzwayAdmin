package com.infoplus.ezway.EzwayAdmin.mapper;

import com.infoplus.ezway.EzwayAdmin.entity.Token;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
@Mapper
public interface TokenMapper {
    Optional<Token> findByToken(String token);
    void revokedToken(Token token);
}
