package com.zhxh.imms.material.vo;

import com.zhxh.imms.material.entity.MaterialMedia;

public class MaterialMediaVO extends MaterialMedia {
    private String mediaType;
    private String mediaUrl;
    private String mediaName;
    private int mediaSize;
    private String mediaDescription;
    private String mediaDataSource;

    public String getMediaName() {
        return mediaName;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public int getMediaSize() {
        return mediaSize;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public String getMediaDataSource() {
        return mediaDataSource;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setMediaSize(int mediaSize) {
        this.mediaSize = mediaSize;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    public void setMediaDataSource(String mediaDataSource) {
        this.mediaDataSource = mediaDataSource;
    }
}