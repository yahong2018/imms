package com.zhxh.admin.entity;

import com.zhxh.core.data.meta.annotation.AutoGenerationType;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration(value = "test_item",keyCreateType = AutoGenerationType.AUTO_INCREMENT)
@Getter
@Setter
public class TestItem {
    private int itemId;
    private String itemCode;
    private String itemValue;
}
