package me.dcal.thermoconnect.propertie;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
    private String staticDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    } 
    public String getStaticDir() {
        return staticDir;
    }

    public void setStaticDir(String staticDir) {
        this.staticDir = staticDir;
    }
}