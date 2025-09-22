package com.infoplus.ezway.EzwayAdmin.controller;

import com.infoplus.ezway.EzwayAdmin.common.MinioBucket;
import com.infoplus.ezway.EzwayAdmin.service.MinioService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private MinioService minioService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private MinioBucket minioBucket;

    @GetMapping("/{category}")
    public ResponseEntity<InputStreamResource> getImage(
            @PathVariable("category") String category,
            @RequestParam("imageName") String imgName) {

        String bucket = minioBucket.getBucket(category);
        InputStream imgStream = minioService.getImage(bucket, imgName);
        String mimeType = URLConnection.guessContentTypeFromName(imgName);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        // Tạo headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(mimeType));

        // Trả về InputStreamResource
        return new ResponseEntity<>(new InputStreamResource(imgStream), headers, HttpStatus.OK);
    }

}
