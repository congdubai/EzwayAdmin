package com.infoplus.ezway.EzwayAdmin.controller;


import com.infoplus.ezway.EzwayAdmin.dto.FaceMatch.FaceMatchDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.FaceMatch.FaceMatchDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailRequest;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse;
import com.infoplus.ezway.EzwayAdmin.service.faceMatch.FaceMatchService;
import com.infoplus.ezway.EzwayAdmin.service.ocr.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2/face-match")
public class FaceMatchController {
    @Autowired
    private FaceMatchService faceMatchService;

    @PostMapping("/detail")
    public ResponseEntity<FaceMatchDetailResponse> getOcrDetail(@RequestBody FaceMatchDetailRequest requestBody) {
        String transId = requestBody.getTransId();
        return ResponseEntity.ok(faceMatchService.doGetFaceMatchDetail(transId));
    }
}
