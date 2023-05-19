package com.codervibe.springbootfileuploaddemo.service;


import com.codervibe.springbootfileuploaddemo.model.Resp;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */
public interface FileUploadService {
    /**
     * 文件上传
     */
    Resp<String> fileUpload(MultipartFile file);
}
