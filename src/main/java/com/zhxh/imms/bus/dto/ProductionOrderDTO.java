package com.zhxh.imms.bus.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductionOrderDTO implements Serializable  {
    private String orderNo;
    private String orderType;
    private String sizeType;
    private String materialNo;
    private int quantity;
    private String mainFabricNo;
    private List<Component> components;
    private List<Measurement> measurements;
    private List<Size> sizes;

    @Getter
    @Setter
    public static class Component implements Serializable {
        private String no;
        private String optionNo;
        private String fabricNo;
    }

    @Getter
    @Setter
    public static class Measurement implements Serializable {
        private String no;
        private int value;
    }

    @Getter
    @Setter
    public static class Size implements Serializable {
        private String size;
        private int count;
    }
}
