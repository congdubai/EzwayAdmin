package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.dto.AuthenticationRequestDTO;
import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.service.AuthenticationService;
import com.infoplus.ezway.EzwayAdmin.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {     
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PutMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto authenticate(@Valid @RequestBody AuthenticationRequestDTO authRequest) {
        return authenticationService.authenticate(authRequest);
    }
}
