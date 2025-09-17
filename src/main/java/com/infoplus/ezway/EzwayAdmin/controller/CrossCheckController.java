package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.CrosscheckDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.CrosscheckDetailResponse;
import com.infoplus.ezway.EzwayAdmin.service.crosscheck.CrosscheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2/cross-check")
public class CrossCheckController {
    @Autowired
    private CrosscheckService crosscheckService;

//    @PostMapping("/detail")
//    public ResponseEntity<CrosscheckDetailResponse> getCrossCheckDetail(@RequestBody CrosscheckDetailRequest requestBody) {
//        long crosscheckId = requestBody.getCrosscheckId();
//        return ResponseEntity.ok(crosscheckService.doGetCrosscheckDetail(crosscheckId));
//    }
}
