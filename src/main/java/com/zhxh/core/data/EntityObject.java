package com.zhxh.core.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public abstract class EntityObject implements Serializable {
    private static long serialVersionUID = 1L;

    private String recordId;
}
