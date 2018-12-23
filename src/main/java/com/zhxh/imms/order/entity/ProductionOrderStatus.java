package com.zhxh.imms.order.entity;

public enum  ProductionOrderStatus {
    /**
     * 产前准备
     */
    PREADY,
    /**
     * 已创建
     */
    CREATED,
    /**
     * 已下达
     */
    RELEASED,
    /**
     * 已发料
     */
    ISSUED,
    /**
     * 已裁剪
     */
    CUTED,
    /**
     * 正在上吊挂
     */
    STITCHING,
    /**
     * 已上吊挂线
     */
    STITCHED,
    /**
     * 已完工
     */
    FINISHED,
}
