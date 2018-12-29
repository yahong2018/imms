package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;

public class Customer extends EntityObject {
    private String rowId;
    private String productionOrderId;
    private String name;
    private String sex;
    private String mailAddress;
    private String telephone;
    private String type;

    public String getRowId() {
        return rowId;
    }

    public String getProductionOrderId() {
        return productionOrderId;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setProductionOrderId(String productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
