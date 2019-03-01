package com.zhxh.imms.media.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("media")
@Getter
@Setter
public class Media extends Entity<Long> {
    private String mediaType;
    private String belongToId;
    private String mediaUrl;
    private String mediaName;
    private int mediaSize;
    private String mediaDescription;
}
