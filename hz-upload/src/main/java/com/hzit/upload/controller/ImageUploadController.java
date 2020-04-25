package com.hzit.upload.controller;

import com.hzit.upload.service.IUploadService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Autowired
    private IUploadService uploadService;

    @PostMapping("/image")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

        //上传业务
        String url = uploadService.upload(file);

        //ResponseEntity:body+head


        return ResponseEntity.ok(url);
    }


}
