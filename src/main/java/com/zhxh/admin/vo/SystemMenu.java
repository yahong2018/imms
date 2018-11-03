package com.zhxh.admin.vo;


import org.apache.commons.lang3.StringUtils;

public class SystemMenu {
    private String programId;
    private String programName;
    private String url;
    private String parameters;
    private Object[] children;
    private String glyph;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getGlyph() {
        return glyph;
    }

    public void setGlyph(String glyph) {
        this.glyph = glyph;
    }

    public boolean isFolder() {
        return StringUtils.isBlank(this.url);
    }

    public boolean isLeaf(){
        return !this.isFolder();
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getProgramId() {
        return programId;
    }

    public String getUrl() {
        return url;
    }

    public String getProgramName() {
        return programName;
    }

    public Object[] getChildren() {
        return children;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }


    public void setChildren(Object[] children) {
        this.children = children;
    }


}
