package com.zhxh.core.data.event;

import com.zhxh.core.backservice.ThreadService;
import com.zhxh.core.utils.Logger;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataUpdateEventListener extends ThreadService implements ApplicationListener<DataUpdateEvent> {
    private List<DataUpdateEvent> cycleEventList = new ArrayList<>();
    private List<DataUpdateConsumer> consumerList = new ArrayList<>();

    @Override
    public void onApplicationEvent(DataUpdateEvent event) {
        if (isRealtimeEvent(event)) {
            dispatchRealtime(event);
        } else {
            synchronized (this) {
                cycleEventList.add(event);
            }
        }
    }

    @Override
    protected void doInternalRun() {
        //复制
        List<DataUpdateEvent> tmpList = this.copy();
        //排序
        this.sort(tmpList);
        //合并
        List<DataUpdateEvent> dispatchList = this.merge(tmpList);
        //分发
        this.dispatchCycle(dispatchList);
    }

    private List<DataUpdateEvent> merge(List<DataUpdateEvent> sourceList) {
        // 1. 对于在同一周期内有新增、修改、删除操作的同一数据，不需要通知
        // 2. 对于在同一周期内有新增、修改的同一数据，合并后的操作类型为新增，数据为修改的数据
        // 3. 对于在同一周期内有多次修改的同一数据，只通知最后一个数据

        return sourceList.stream().distinct().collect(Collectors.toList());
    }

    private void removeInsertAndDelete(List<DataUpdateEvent> sourceList) {
        for (int i = 0; i < sourceList.size(); i++) {

        }
    }

    private List<DataUpdateEvent> copy() {
        List<DataUpdateEvent> tmpList = new ArrayList<>();
        synchronized (this) {
            tmpList.addAll(this.cycleEventList);
            this.cycleEventList.clear();
        }
        return tmpList;
    }

    private void dispatchCycle(List<DataUpdateEvent> tmpList) {
        for (DataUpdateEvent event : tmpList) {
            String key = event.getItem().getClass().getCanonicalName();
            for (DataUpdateConsumer consumer : this.consumerList) {
                try {
                    if (key.equalsIgnoreCase(consumer.getItemClassName())) {
                        consumer.consume(event);
                    }
                } catch (Exception e) {
                    Logger.error("分发数据更新通知错误：" + e.getMessage());
                }
            }
        }
    }

    private void sort(List<DataUpdateEvent> sourceList){
        sourceList.sort((x1, x2) -> {
            if (x1 instanceof Comparable) {
                return ((Comparable) x1.getItem()).compareTo(x2.getItem());
            }
            return ((Integer) x1.hashCode()).compareTo(x2.hashCode());
        });
    }

    private void dispatchRealtime(DataUpdateEvent event) {
    }

    private boolean isRealtimeEvent(DataUpdateEvent event) {
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
