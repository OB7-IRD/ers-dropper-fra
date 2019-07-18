package fr.ird.dropper.ers.fra.business;

import java.util.Date;

/**
 * Table des fichiers(XML) de l'application.
 *
 * @author christelle.jeanberne
 */
public class OrionFileDescriptor {

    Long id;

    String fileName;

    String filePath;

    Date lastUpdated;

    int fileSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filename) {
        this.fileName = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filepath) {
        this.filePath = filepath;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(long l) {
        this.fileSize = (int) l;
    }
}
