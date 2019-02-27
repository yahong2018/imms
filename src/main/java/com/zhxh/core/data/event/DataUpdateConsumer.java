package com.zhxh.core.data.event;

public interface DataUpdateConsumer {
    void consume(DataUpdateEvent event);
}
