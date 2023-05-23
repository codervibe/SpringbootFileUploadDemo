package com.codervibe.springbootfileuploaddemo.controller;


import com.codervibe.springbootfileuploaddemo.model.Resp;
import com.codervibe.springbootfileuploaddemo.service.FileUploadService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 * 文件上传接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/file")
public class FileUploadController {
    @Resource
    private FileUploadService fileUploadService;
    private Log log = LogFactory.getLog(this.getClass());
    private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    private Resp<String> upload(@RequestParam("file") MultipartFile file) {
        log.info("上传文件 方法 执行");

        return fileUploadService.fileUpload(file);
    }
    @RequestMapping(value = "/uploadandownload", method = RequestMethod.POST)
    private Map<String,Object> uploadandownload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        log.info("上传下载 文件 方法 执行");
        Map<String,Object> result =new HashMap<>();
        String originalFilename = file.getOriginalFilename();
        String 当前时间 = timeFormat.format(new Date());
        String realPath = request.getServletContext().getRealPath("/") + 当前时间;
        log.info("realPath = "+realPath);
        File folder =new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String newName = UUID.randomUUID()
                +"."+originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        log.info("newName = "+newName);
        File realfile =new File(folder,newName);
        try {
            file.transferTo(realfile);
            String url = request.getScheme()+"://"+request.getServerName() + ":"+request.getServerPort() +"/"+
                    当前时间 + newName;
            log.info("url="+url);
            result.put("code",200);
            result.put("url",url);
        }catch (IOException e) {
            result.put("code",400);
            result.put("message",e.getMessage());
        }
        boolean fileExists = realfile.exists();
        if (fileExists) {
            log.info("文件存在 文件保存成功");
        } else {
            log.warn("文件不存在 文件保存失败！");
        }
        return  result;

    }


}
