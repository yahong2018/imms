package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import org.apache.commons.lang3.StringUtils;

public class SystemProgram extends EntityObject {
    public final static int PROGRAM_STATUS_STOPPED = 1;
    public final static int PROGRAM_STATUS_NORMAL = 0;

    private String programId;
    private String programName;
    private String url;
    private int showOrder;
    private String parameters;
    private String parent;
    private String glyph;

    public String getGlyph() {
        return glyph;
    }

    public void setGlyph(String glyph) {
        this.glyph = glyph;
    }

    public boolean isFolder() {
        return StringUtils.isBlank(this.url);
    }

    public boolean isTopMenu() {
        return this.programId.equals(this.parent);
    }

    public String getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }

    public String getUrl() {
        return url;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getShowOrder() {
        return showOrder;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setShowOrder(int showOrder) {
        this.showOrder = showOrder;
    }

}
