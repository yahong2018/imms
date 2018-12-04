package com.zhxh.imms.material.entity;

public enum BomOrderType {
    PART_BOM("P",""),
    STANDARD_BOM("S",""),
    ORDER_BOM("O",""),
    DESIGN_BOM("D",""),
    MANUFACTURE_BOM("M",""),
    WORK_BOM("W","");

    private String code;
    private String name;

    BomOrderType(String code,String name){

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
