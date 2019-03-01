package com.zhxh.core.data.event;

import java.util.List;

public interface DataUpdateConsumer {
    List<String> getSubscribeTable();
    void consume(DataUpdateEvent event);
}
