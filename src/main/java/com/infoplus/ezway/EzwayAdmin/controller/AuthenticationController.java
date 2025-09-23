package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.dto.AuthenticationRequestDTO;
import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthRequest;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthResponse;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationRequest;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationResponse;
import com.infoplus.ezway.EzwayAdmin.service.AuthenticationService;
import com.infoplus.ezway.EzwayAdmin.service.JwtService;
import com.infoplus.ezway.EzwayAdmin.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthService authService;
    @Autowired
    private final AuthenticationService authenticationService;
    @Autowired
    private final JwtService jwtService;

    @PutMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto authenticate(@Valid @RequestBody AuthenticationRequestDTO authRequest) {
        return authenticationService.authenticate(authRequest);
    }


    @PostMapping("/list")
    public ResponseEntity<AuthResponse> getListAuth(@RequestBody AuthRequest requestBody) throws ExecutionException, InterruptedException {
        AuthResponse res = authService.doGetListAuthentication(requestBody);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/detail")
    public ResponseEntity<AuthDetailResponse> getAuthDetail(@RequestBody AuthDetailRequest requestBody) {
        String transId = requestBody.getTransId();
        return ResponseEntity.ok(authService.doGetAuthDetail(transId));
    }
    @PutMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }

    @GetMapping("/verify-token")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto verifyAccessToken(HttpServletRequest request) throws IOException {
        return jwtService.verifyToken(request);

    }
}
