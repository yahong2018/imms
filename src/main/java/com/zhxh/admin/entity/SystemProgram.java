package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@DataTable("system_program")
@Getter
@Setter
public class SystemProgram extends EntityObject {
    private String programCode;
    private String programName;
    private String url;
    private int showOrder;
    private String parameters;
    private String parentId;
    private String glyph;

    public boolean isTopMenu() {
        return this.getRecordId().equalsIgnoreCase(this.parentId);
    }

    public boolean isFolder() {
        return StringUtils.isEmpty(this.url);
    }
}
