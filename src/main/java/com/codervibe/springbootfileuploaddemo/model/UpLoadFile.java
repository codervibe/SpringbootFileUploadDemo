package com.codervibe.springbootfileuploaddemo.model;

/**
 * @author Administrator
 * 上传的文件
 */
public class UpLoadFile {
    /**
     * 上传文件名
     */
    private String uploadFileName;
    /**
     * 文件存储路径
     */
    private String fileStoragePath;
    /**
     * 文件存储名
     */
    private String fileStorageName;

    public UpLoadFile() {
    }

    public UpLoadFile(String uploadFileName, String fileStoragePath, String fileStorageName) {
        this.uploadFileName = uploadFileName;
        this.fileStoragePath = fileStoragePath;
        this.fileStorageName = fileStorageName;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getFileStoragePath() {
        return fileStoragePath;
    }

    public void setFileStoragePath(String fileStoragePath) {
        this.fileStoragePath = fileStoragePath;
    }

    public String getFileStorageName() {
        return fileStorageName;
    }

    public void setFileStorageName(String fileStorageName) {
        this.fileStorageName = fileStorageName;
    }

    @Override
    public String toString() {
        return "UpLoadFile{" +
                "uploadFileName='" + uploadFileName + '\'' +
                ", fileStoragePath='" + fileStoragePath + '\'' +
                ", fileStorageName='" + fileStorageName + '\'' +
                '}';
    }
}
