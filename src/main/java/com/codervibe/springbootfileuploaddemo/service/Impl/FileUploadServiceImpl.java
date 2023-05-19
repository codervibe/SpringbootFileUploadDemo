package com.codervibe.springbootfileuploaddemo.service.Impl;


import com.codervibe.springbootfileuploaddemo.model.Resp;
import com.codervibe.springbootfileuploaddemo.service.FileUploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    Log log = LogFactory.getLog(this.getClass());
    SimpleDateFormat timeFormatForSendingMail = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 文件上传
     */
    @Override
    public Resp<String> fileUpload(MultipartFile file) {
        log.info("文件上传服务.......");
        if (file.isEmpty()) {
            return Resp.fail("400", "文件为空");
        }
        String OriginalFileName = file.getOriginalFilename();
        String 当前时间 = timeFormatForSendingMail.format(new Date());
        log.info("当前时间: "+当前时间);
        log.info("原本的文件名："+ OriginalFileName);
        String 文件名 =  OriginalFileName.substring(0,OriginalFileName.indexOf("."));
        String fileName = 当前时间 + 文件名 +"."
                + OriginalFileName.substring(OriginalFileName.lastIndexOf(".") + 1);
        String filePath = "C:\\Users\\Default\\AppData\\Local\\FileUploadDemo\\";
        log.info("filePath" + filePath);
        log.info("保存的文件名："+ 文件名);
        log.info("文件保存位置：" + filePath + fileName);
        File newFile = new File(filePath + fileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.fail("500",
                    OriginalFileName + "上传失败");
        }
        boolean fileExists = newFile.exists();
        if (fileExists) {
            log.info("文件存在 文件保存成功");
        } else {
            log.warn("文件不存在 文件保存失败！");
        }
        return Resp.success(fileName);
    }
}
