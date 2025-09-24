package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationRequest;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationResponse;
import com.infoplus.ezway.EzwayAdmin.mapper.RegistrationMapper;
import com.infoplus.ezway.EzwayAdmin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/v2/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/list")
    public ResponseEntity<RegistrationResponse> getListCrosscheck(@RequestBody RegistrationRequest requestBody) throws ExecutionException, InterruptedException {
        RegistrationResponse res = registrationService.doGetListRegistration(requestBody);
        return ResponseEntity.ok(res);
    }
}
