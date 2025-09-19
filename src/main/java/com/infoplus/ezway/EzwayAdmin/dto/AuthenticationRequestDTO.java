package com.infoplus.ezway.EzwayAdmin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
public class AuthenticationRequestDTO {
    @Schema(example = "tienlm@infoplusvn.com", description = "Your email address", type = "String")
    private String email;

    @Schema(example = "tien0001", description = "Your employee id", type = "String")
    @NotBlank(message = "Employee Id required!")
    private String employeeId;

    @Schema(example = "Info@123", description = "Your password", type = "String")
    @NotBlank(message = "Password is required!")
    private String password;

}
