package com.infoplus.ezway.EzwayAdmin.common;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MinioBucket {
    @Value("${minio.verify-bucket}")
    private String verifyBucket;
    @Value("${minio.selfie-bucket}")
    private String selfieBucket;
    @Value("${minio.ocr-bucket}")
    private String ocrBucket;
    @Value("${minio.c06-bucket}")
    private String c06Bucket;
    @Value("${minio.pp-nfc-bucket}")
    private String ppNfcBucket;

    private Map<String, String> bucket = new HashMap<String, String>();

    @PostConstruct
    private void init() {
        bucket.put("verify", verifyBucket);
        bucket.put("selfie", selfieBucket);
        bucket.put("idcard", ocrBucket);
        bucket.put("idroi", ocrBucket);
        bucket.put("irar", c06Bucket);
        bucket.put("ppnfc", ppNfcBucket);
    }

    public String getBucket(String cate) {
        return bucket.get(cate);
    }
}
