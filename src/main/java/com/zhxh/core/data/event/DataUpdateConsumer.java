package com.zhxh.core.data.event;

public interface DataUpdateConsumer {
    String getItemClassName();
    void consume(DataUpdateEvent event);
}
