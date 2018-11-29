package com.zhxh.imms.media.entity;

import com.zhxh.core.data.EntityObject;

public class Media implements EntityObject {
    private String rowId;
    private String type;
    private String url;
    private String name;
    private int size;
    private String description;
    private String source;

    public String getRowId() {
        return rowId;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
