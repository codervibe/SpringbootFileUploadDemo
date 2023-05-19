package com.codervibe.springboot_fileuploaddemo.controller;

import com.codervibe.springboot_fileuploaddemo.model.Resp;
import com.codervibe.springboot_fileuploaddemo.service.FileUploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Administrator
 * 文件上传接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/file")
public class FileUploadController {
    @Resource
    FileUploadService fileUploadService;
    Log log = LogFactory.getLog(this.getClass());
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    private Resp<String> upload(@RequestParam("file") MultipartFile file) {
        log.info("上传文件 方法 执行");

        return fileUploadService.fileUpload(file);
    }


}
