package com.zhxh.imms.misc.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("media")
@Getter
@Setter
public class Media extends EntityObject<Long> {
    private String mediaType;
    private String belongToId;
    private String mediaUrl;
    private String mediaName;
    private int mediaSize;
    private String mediaDescription;
}
