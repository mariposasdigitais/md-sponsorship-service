package mariposas.service.impl;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;
import mariposas.exception.BaseException;
import mariposas.service.S3Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.utils.IoUtils;

import static mariposas.constant.AppConstant.BUCKET_PATH;
import static mariposas.constant.AppConstant.GET_IMAGE_ERROR;

@Singleton
public class S3ServiceImpl implements S3Service {
    private final S3Client s3Client;
    private final String bucketName;

    public S3ServiceImpl(S3Client s3Client, @Value("${aws.s3.bucket-name}") String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    @Override
    public byte[] getImageFile(String name) {
        var getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(BUCKET_PATH + name)
                .build();

        try {
            var response = s3Client.getObject(getObjectRequest);
            return IoUtils.toByteArray(response);
        } catch (Exception e) {
            throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY, GET_IMAGE_ERROR);
        }
    }
}