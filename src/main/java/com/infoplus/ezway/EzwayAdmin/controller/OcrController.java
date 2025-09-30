package com.infoplus.ezway.EzwayAdmin.controller;


import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse2;
import com.infoplus.ezway.EzwayAdmin.service.ocr.OcrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2/ocr")
@Slf4j
public class OcrController {
    @Autowired
    private OcrService ocrService;

    @PostMapping("/detail")
    public ResponseEntity<OcrDetailResponse> getOcrDetail(@RequestBody OcrDetailRequest requestBody) {
        String transId = requestBody.getTransId();
        return ResponseEntity.ok(ocrService.doGetOcrDetail(transId));
    }
    @PostMapping("/detail2")
    public ResponseEntity<OcrDetailResponse2> getOcrDetail2(@RequestBody OcrDetailRequest requestBody) {
        String transId = requestBody.getTransId();
        return ResponseEntity.ok(ocrService.doGetOcrDetail2(transId));
    }
}
