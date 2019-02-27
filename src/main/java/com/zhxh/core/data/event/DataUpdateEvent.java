package com.zhxh.core.data.event;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class DataUpdateEvent extends ApplicationEvent {
    public DataUpdateEvent(Object source,Object item,int dataOperationType) {
        super(source);

        this.item = item;
        this.createTime = LocalDateTime.now();
        this.dataOperationType = dataOperationType;
    }

    private int dataOperationType;

    public int getDataOperationType() {
        return dataOperationType;
    }

    private LocalDateTime createTime;
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    private Object item;
    public Object getItem() {
        return item;
    }
}
