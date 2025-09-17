package com.infoplus.ezway.EzwayAdmin.advice;


import com.infoplus.ezway.EzwayAdmin.definition.ErrorCode;
import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.exception.LimitedAccessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<BaseResponseDto> handleAuthenticationException(AuthenticationException ex) {
        if (ex instanceof UsernameNotFoundException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponseDto(ErrorCode.E06.getCode(), ErrorCode.E06.getDesc()));
        } else if (ex instanceof LockedException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponseDto(ErrorCode.E07.getCode(), ErrorCode.E07.getDesc()));
        } else if (ex instanceof LimitedAccessException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponseDto(ErrorCode.E08.getCode(), ErrorCode.E08.getDesc()));
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDto(ErrorCode.E02.getCode(), ErrorCode.E02.getDesc()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponseDto> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BaseResponseDto(ErrorCode.E03.getCode(), ErrorCode.E03.getDesc()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseDto> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponseDto(ErrorCode.E01.getCode(), ErrorCode.E03.getDesc()));
    }
}
