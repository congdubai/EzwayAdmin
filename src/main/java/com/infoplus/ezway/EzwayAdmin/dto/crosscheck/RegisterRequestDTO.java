package com.infoplus.ezway.EzwayAdmin.dto.crosscheck;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    @NotBlank(message = "employeeId is required!")
    private String employeeId;

    @NotBlank(message = "Password is required!")
    @Schema(example = "info@1234", description = "Your password", type = "String")
    private String password;

    @NotBlank
    private String fullName;

    @Schema(example = "tienlm@infoplusvn.com", description = "Your email address", type = "String")

    private String email;

    private String department;

    @NotBlank
    private String role;

    private int pin;
    private String host;
    private int visit;
    private boolean banned = false;
    private String telNumber;
    private String authority;
    private String status;
}
