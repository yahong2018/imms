package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Line;

public class LineVO extends Line {
    private String startMainLineNo;
    private String endMainLineNo;
    private String workCenterNo;
    private String workStationName;

    public String getWorkCenterNo() {
        return workCenterNo;
    }

    public String getWorkStationName() {
        return workStationName;
    }

    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    public String getStartMainLineNo() {
        return startMainLineNo;
    }

    public String getEndMainLineNo() {
        return endMainLineNo;
    }

    public void setWorkCenterNo(String workCenterNo) {
        this.workCenterNo = workCenterNo;
    }

    public void setStartMainLineNo(String startMainLineNo) {
        this.startMainLineNo = startMainLineNo;
    }

    public void setEndMainLineNo(String endMainLineNo) {
        this.endMainLineNo = endMainLineNo;
    }
}
