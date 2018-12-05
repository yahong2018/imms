Ext.define("app.view.imms.material.material.MaterialBasicForm", {
    extend: "Ext.form.FormPanel",
    xtype: "app_view_imms_material_material_MaterialBasicForm",
  //  requires: ["app.ux.filterButton.FilterButton", "app.store.imms.code.MaterialTypeStore"],
    uses: ["app.ux.filterButton.FilterButton", "app.store.imms.code.MaterialTypeStore"],
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    items: [
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "materialId",
                    fieldLabel: "物料Id",
                    xtype: "hidden",
                },
                {
                    name: "materialNo",
                    fieldLabel: "物料编码",
                    xtype: "textfield",
                    maxLength: 12,
                    allowBlank: false,
                    enforceMaxLength: true,
                    width: 330,
                }
            ]
        },
        {
            name: "materialName",
            fieldLabel: "物料名称",
            xtype: "textfield",
            maxLength: 30,
            labelWidth: 100,
            allowBlank: false,
            enforceMaxLength: true,
            flex: 1
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "materialMaterialTypeId",
                    fieldLabel: "物料类型Id",
                    xtype: "hidden",
                },
                {
                    xtype: "container",
                    layout: "hbox",
                    flex: 0.5,
                    items: [
                        {
                            name: "materialTypeNo",
                            fieldLabel: "类型编码",
                            xtype: "textfield",
                            readOnly: true,
                            maxLength: 10,
                            enforceMaxLength: true,
                            width: 301,
                            allowBlank: false,
                        }, {
                            xtype: "filterButton",
                            baseClass: "treeGrid",
                            width: 30,
                            columns: [
                                {
                                    xtype: 'treecolumn',
                                    text: '类型代码',
                                    dataIndex: 'materialTypeNo',
                                    width: 250
                                },
                                {
                                    text: '类型名称',
                                    dataIndex: 'materialTypeName',
                                    width: 200,
                                },
                                {
                                    text: '类型描述',
                                    dataIndex: 'materialTypeDescription',
                                    flex: 1
                                }
                            ],
                            store: Ext.create({ xtype: "app_store_imms_code_MaterialTypeStore" }),
                            callback: function (grid, selectedRecords) {
                                var record = selectedRecords[0];

                                var txtMaterialTypeId = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='materialMaterialTypeId']");
                                txtMaterialTypeId.setValue(record.get("materialTypeId"));

                                var txtMaterialTypeNo = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='materialTypeNo']");
                                txtMaterialTypeNo.setValue(record.get("materialTypeNo"));

                                var txtMaterialTypeName = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='materialTypeName']");
                                txtMaterialTypeName.setValue(record.get("materialTypeName"));
                            }
                        }
                    ]
                },
                {
                    xtype: "label",
                    flex: 0.5
                }
            ]
        },
        {
            name: "materialTypeName",
            fieldLabel: "类型名称",
            xtype: "textfield",
            readOnly: true,
            labelWidth: 100,
            flex: 1
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "materialSizeId",
                    fieldLabel: "尺码组Id",
                    xtype: "hidden",
                },
                {
                    xtype: "container",
                    layout: "hbox",
                    flex: 0.5,
                    items: [
                        {
                            name: "sizeNo",
                            fieldLabel: "尺码组编码",
                            xtype: "textfield",
                            maxLength: 10,
                            enforceMaxLength: true,
                            width: 301,
                            allowBlank: false,
                            readOnly: true,
                        }, {
                            xtype: "filterButton",
                            baseClass: "treeGrid",
                            width: 30,
                            columns: [
                                {
                                    xtype: 'treecolumn',
                                    text: '尺码代码',
                                    dataIndex: 'sizeNo',
                                    width: 250
                                },
                                {
                                    text: '尺码名称',
                                    dataIndex: 'sizeName',
                                    width: 200,
                                },
                                {
                                    text: '尺码描述',
                                    dataIndex: 'sizeDescription',
                                    flex: 1
                                }
                            ],
                            store: Ext.create({ xtype: "app_store_imms_code_SizeStore" }),
                            callback: function (grid, selectedRecords) {
                                var record = selectedRecords[0];

                                var txtSizeId = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='materialSizeId']");
                                txtSizeId.setValue(record.get("sizeId"));

                                var txtSizeNo = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='sizeNo']");
                                txtSizeNo.setValue(record.get("sizeNo"));

                                var txtSizeName = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='sizeName']");
                                txtSizeName.setValue(record.get("sizeName"));
                            }
                        }
                    ]
                },
                {
                    xtype: "label",
                    flex: 0.5
                }
            ]
        },
        {
            name: "sizeName",
            fieldLabel: "尺码组名称",
            xtype: "textfield",
            readOnly: true,
            labelWidth: 100,
            flex: 1
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "materialUomId",
                    fieldLabel: "计量单位Id",
                    xtype: "hidden",
                },
                {
                    xtype: "container",
                    layout: "hbox",
                    flex: 0.5,
                    items: [
                        {
                            name: "uomNo",
                            fieldLabel: "计量单位编码",
                            xtype: "textfield",
                            maxLength: 10,
                            enforceMaxLength: true,
                            width: 301,
                            allowBlank: false,
                            readOnly: true,
                        }, {
                            xtype: "filterButton",
                            width: 30,
                            columns: [
                                {
                                    text: '单位代码',
                                    dataIndex: 'uomNo',
                                    width: 250
                                },
                                {
                                    text: '单位名称',
                                    dataIndex: 'uomName',
                                    width: 200,
                                },
                                {
                                    text: '单位描述',
                                    dataIndex: 'uomDescription',
                                    flex: 1
                                }
                            ],
                            store: Ext.create({ xtype: "app_store_imms_code_UomStore" }),
                            callback: function (grid, selectedRecords) {
                                var record = selectedRecords[0];
                                var txtUomId = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='materialUomId']");
                                txtUomId.setValue(record.get("uomId"));

                                var txtUomNo = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='uomNo']");
                                txtUomNo.setValue(record.get("uomNo"));

                                var txtUomName = this.up("app_view_imms_material_material_MaterialBasicForm").down("[name='uomName']");
                                txtUomName.setValue(record.get("uomName"));
                            }
                        }
                    ]
                },
                {
                    name: "uomName",
                    fieldLabel: "计量单位名称",
                    xtype: "textfield",
                    readOnly: true,
                    margin: '0 0 0 20',
                    flex: 0.5
                }
            ]
        },

        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [

                {
                    name: "materialWidth",
                    fieldLabel: "宽幅",
                    xtype: "numberfield",
                    width: 331,
                    allowDecimals: true,                   
                    decimalPrecision: 2,
                    hideTrigger: true,
                },
                {
                    name: "materialWeight",
                    fieldLabel: "纺织克重",
                    xtype: "numberfield",
                    margin: '0 0 0 20',
                    flex: 0.5,
                    allowDecimals: true,                   
                    decimalPrecision: 2,
                    hideTrigger: true,
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "materialPrice",
                    fieldLabel: "价格",
                    xtype: "numberfield",
                    width: 331,
                    allowDecimals: true,                   
                    decimalPrecision: 2,
                    hideTrigger: true,                   
                },
                {
                    name: "materialColor",
                    fieldLabel: "颜色",
                    xtype: "textfield",
                    margin: '0 0 0 20',
                    flex: 0.5
                }
            ]
        }, {
            name: "materialDescription",
            xtype: "textfield",
            labelWidth: 100,
            fieldLabel: "物料描述",
            flex: 1,
            // margin: '0 18 0 0',
        }
    ]
});