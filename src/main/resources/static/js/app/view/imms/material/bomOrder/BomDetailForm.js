Ext.define("app.view.imms.material.bomOrder.BomDetailForm", {
    extend: "Ext.form.Panel",
    xtype: "app_view_imms_material_bomOrder_BomDetailForm",
    uses: ["app.ux.data.DataMode"],

    bodyPadding: 3,
    layout: "anchor",
    width: 600,
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    items: [
        {
            xtype: "hidden",
            name: "bom_id",
        }, {
            xtype: "hidden",
            name: "bomBomOrderId",
        }, {
            xtype: "hidden",
            name: "componentAbstractMaterialId"
        }, {
            xtype: "hidden",
            name: "componentMaterialMatchRuleId"
        }, {
            xtype: "hidden",
            name: "parentBomId"
        }, {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 3 ',
            items: [
                {
                    name: "componentMaterialId",
                    xtype: "hidden",
                },
                {
                    xtype: "container",
                    layout: "hbox",
                    flex: 0.5,
                    items: [
                        {
                            name: "componentMaterialNo",
                            fieldLabel: "组件编码",
                            xtype: "textfield",
                            readOnly: true,
                            maxLength: 10,
                            enforceMaxLength: true,
                            width: 245,
                            allowBlank: false,
                        }, {
                            xtype: "filterButton",
                            width: 30,
                            columns: [
                                {
                                    text: '物料编码',
                                    dataIndex: 'materialNo',
                                    width: 150
                                },
                                {
                                    text: '物料名称',
                                    dataIndex: 'materialName',
                                    flex: 1
                                }
                            ],
                            store: Ext.create({ xtype: "app_store_imms_material_MaterialStore" }),
                            callback: function (grid, selectedRecords) {
                                var record = selectedRecords[0];
                                var me = this.up("app_view_imms_material_bomOrder_BomDetailForm");

                                var txtComponentMaterialId = me.down("[name='componentMaterialId']");
                                txtComponentMaterialId.setValue(record.get("materialId"));

                                var txtComponentMaterialNo = me.down("[name='componentMaterialNo']");
                                txtComponentMaterialNo.setValue(record.get("materialTypeNo"));

                                var txtMaterialName = me.down("[name='materialName']");
                                txtMaterialName.setValue(record.get("materialName"));
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
            name: "materialName",
            fieldLabel: "组件名称",
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
                    xtype: "numberfield",
                    name: "componentQty",
                    fieldLabel: "组件用量",
                    allowBlank: false,
                    allowDecimals: true,
                    hideTrigger: true,
                    width: 275,
                }, {
                    xtype: "label",
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
                    xtype: "hidden",
                    name: "componentMaterialUomId"
                },
                {
                    xtype: "container",
                    layout: "hbox",
                    flex: 0.5,
                    items: [
                        {
                            xtype: "textfield",
                            name: "componentMaterialUomNo",
                            fieldLabel: "用量单位",
                            readOnly: true,
                            width: 245,
                            allowBlank: false,
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
                                var me = this.up("app_view_imms_material_bomOrder_BomDetailForm");
                                var txtUomId = me.down("[name='componentMaterialUomId']");
                                txtUomId.setValue(record.get("uomId"));

                                var txtUomNo = me.down("[name='componentMaterialUomNo']");
                                txtUomNo.setValue(record.get("uomNo"));

                                var txtUomName = me.down("[name='componentMaterialUomName']");
                                txtUomName.setValue(record.get("uomName"));
                            }
                        }
                    ]
                }
            ]
        }, {
            xtype: "textfield",
            name: "componentMaterialUomName",
            fieldLabel: "单位名称",
            readOnly: true,
            labelWidth: 100,
            flex: 1
        },
        {
            xtype: "textfield",
            name: "componentTypeNo",
            fieldLabel: "组件类型",
            labelWidth: 100,
            flex: 0.5
        }, {
            xtype: "checkbox",
            name: "ifMainFabric",
            fieldLabel: "是否主面料",
            labelWidth: 100,
            flex: 0.5
        }
        , {
            xtype: "textfield",
            name: "bomDataSource",
            fieldLabel: "数据来源",
            labelWidth: 100,
            flex: 0.5
        }
    ],
    onRecordLoad: function (e) {
        if (e.dataMode != app.ux.data.DataMode.INSERT) {
            return;
        }

        if (e.sender.btnName == "btnInsertBrother") {

        } else if (e.sender.btnName == 'btnInsert') {

        }
    }
});