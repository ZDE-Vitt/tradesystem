package com.gem.tradesystem.service;

import org.springframework.web.multipart.MultipartFile;
//上传图片接口
public interface UploadFile {
    String uploadFile(MultipartFile file);
}
