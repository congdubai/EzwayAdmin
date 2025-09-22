package com.infoplus.ezway.EzwayAdmin.service;

import com.infoplus.ezway.EzwayAdmin.exception.MinioConnectException;
import io.minio.MinioClient;
import io.minio.GetObjectArgs;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Service
@RequiredArgsConstructor
@Slf4j
public class MinioService {

    private final MinioClient minioClient;

    public InputStream getImage(String bucketName, String objectName) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
        } catch (MinioException | InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioConnectException(String.format("An error occurred while getting the images from MinIo with bucketName=%s objectName=%s"
                    , bucketName, objectName), e);
        }
    }

}