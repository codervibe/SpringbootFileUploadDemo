package com.codervibe.springboot_fileuploaddemo.service;

import com.codervibe.springboot_fileuploaddemo.model.Resp;
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
