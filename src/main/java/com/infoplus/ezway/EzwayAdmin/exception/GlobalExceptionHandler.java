package com.infoplus.ezway.EzwayAdmin.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    // Handle validation errors
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
//        Map<String, Object> response = new HashMap<>();
//
//        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
//                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        // Xử lý thông báo lỗi cho resultDesc
//        String resultDesc = String.join(", ", errorMessages);
//
//        // Customize response
//        response.put("resultCode", GmoResultCode.VALUE_1);
//        response.put("resultDesc", resultDesc);
//
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(RegisterWithIdCardException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Map<String, Object> handleRegisterWithIdCardException(RegisterWithIdCardException ex) {
//        return Map.of(
//                "resultCode", ErrorCode.UNEXPECTED_ERROR.getCode(),
//                "resultDesc", ex.getMessage()
//        );
//    }
}
