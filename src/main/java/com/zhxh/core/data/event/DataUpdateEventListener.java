package com.zhxh.core.data.event;

import com.zhxh.core.backservice.ThreadService;
import com.zhxh.core.utils.Logger;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DataUpdateEventListener extends ThreadService implements ApplicationListener<DataUpdateEvent> {
    private List<DataUpdateEvent> cycleEventList = new ArrayList<>();
    private Hashtable<String, DataUpdateConsumer> consumerList = new Hashtable<>();

    @Override
    public void onApplicationEvent(DataUpdateEvent dataUpdateEvent) {
        if (isRealtimeEvent(dataUpdateEvent)) {
            dispatchRealtime(dataUpdateEvent);
        } else {
            synchronized (this) {
                cycleEventList.add(dataUpdateEvent);
            }
        }
    }

    @Override
    protected void doInternalRun() {
        List<DataUpdateEvent> tmpList = this.copy();
        this.merge(tmpList);
        this.dispatchCycle(tmpList);
    }

    private List<DataUpdateEvent> copy() {
        List<DataUpdateEvent> tmpList = new ArrayList<>();
        synchronized (this) {
            tmpList.addAll(this.cycleEventList);
            this.cycleEventList.clear();
        }
        return tmpList;
    }

    private void merge(List<DataUpdateEvent> tmpList) {
        //
        //合并相同数据在同一周期内的更新事件
        //
    }

    private void dispatchCycle(List<DataUpdateEvent> tmpList) {
        for (DataUpdateEvent event : tmpList) {
            String key = event.getItem().getClass().getCanonicalName();
            if (this.consumerList.containsKey(key)) {
                try {
                    this.consumerList.get(key).consume(event);
                } catch (Exception e) {
                    Logger.error("分发数据更新通知错误：" + e.getMessage());
                }
            }
        }
    }

    private void dispatchRealtime(DataUpdateEvent dataUpdateEvent) {

    }

    private boolean isRealtimeEvent(DataUpdateEvent dataUpdateEvent) {
        return false;
    }

    @Override
    protected boolean doInternalInit() {
        return true;
    }

    @Override
    public void clean() {
    }
}
