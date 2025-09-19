package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.RegisterRequestDTO;
import com.infoplus.ezway.EzwayAdmin.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
@RequiredArgsConstructor
public class AdminController {
    private final AuthenticationService authenticationService;

    @Operation(
            description = "Register a new user",
            summary = "This is a summary for authentication get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad request",
                            responseCode = "400"
                    )
            }

    )
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PostMapping("/register-account")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto register(@Valid @RequestBody RegisterRequestDTO authRequest) {
        return authenticationService.register(authRequest);
    }
}
