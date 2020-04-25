package com.hzit.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    /**
     * 上传图片，获取上传的路径
     * @param file
     * @return
     */
    public String upload(MultipartFile file);

}
