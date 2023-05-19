package com.codervibe.springboot_fileuploaddemo.service.Impl;

import com.codervibe.springboot_fileuploaddemo.model.Resp;
import com.codervibe.springboot_fileuploaddemo.service.FileUploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Administrator
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    Log log = LogFactory.getLog(this.getClass());
    /**
     * 文件上传
     */
    @Override
    public Resp<String> fileUpload(MultipartFile file) {
        log.info("文件上传服务.......");
        if (file.isEmpty()) {
            return Resp.fail("400","文件为空");
        }
        String OriginalFileName = file.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "."
                +OriginalFileName.substring(OriginalFileName.lastIndexOf(".")+1);
        String filePath = "C:\\Users\\Default\\AppData\\Local\\FileUploadDemo\\";
        log.info("filePath"+filePath);
        log.info("文件保存位置："+filePath+fileName);
        File dest = new File(filePath+fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
            try {
                file.transferTo(dest);
            } catch (Exception e) {
                e.printStackTrace();
                return Resp.fail("500",
                        OriginalFileName+"上传失败");
            }
        }
        return Resp.success(fileName);
    }
}
