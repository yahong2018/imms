Ext.define("app.view.imms.material.material.MaterialBasicForm", {
    extend: "Ext.form.FormPanel",
    xtype: "app_view_imms_material_material_MaterialBasicForm",
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    items: [
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5 ',
            items: [
                {
                    name: "materialNo",
                    fieldLabel: "物料编码",
                    xtype: "textfield",
                    maxLength: 12,
                    enforceMaxLength: true,
                },
                {
                    name: "materialName",
                    fieldLabel: "物料名称",
                    xtype: "textfield",
                    maxLength: 30,
                    margin: '0 0 0 20',
                    enforceMaxLength: true,
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5',

            items: [
                {
                    name: "materialMaterialTypeId",
                    fieldLabel: "物料类型Id",
                    xtype: "hidden",
                },
                {
                    name: "materialTypeNo",
                    fieldLabel: "类型编码",
                    xtype: "textfield",
                    maxLength: 10,
                    enforceMaxLength: true,
                },
                {
                    name: "materialTypeName",
                    fieldLabel: "类型名称",
                    xtype: "textfield",
                    readOnly: true,
                    margin: '0 0 0 20',
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5',
            items: [
                {
                    name: "materialUomId",
                    fieldLabel: "计量单位Id",
                    xtype: "hidden",
                },
                {
                    name: "uomNo",
                    fieldLabel: "计量单位编码",
                    xtype: "textfield",
                    maxLength: 10,
                    enforceMaxLength: true,
                },
                {
                    name: "uomName",
                    fieldLabel: "计量单位名称",
                    xtype: "textfield",
                    readOnly: true,
                    margin: '0 0 0 20',
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5',
            items: [
                {
                    name: "materialSizeId",
                    fieldLabel: "尺码组Id",
                    xtype: "hidden",
                },
                {
                    name: "sizeNo",
                    fieldLabel: "尺码组编码",
                    xtype: "textfield",
                    maxLength: 10,
                    enforceMaxLength: true,
                },
                {
                    name: "sizeName",
                    fieldLabel: "尺码组名称",
                    xtype: "textfield",
                    readOnly: true,
                    margin: '0 0 0 20',
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5',
            items: [

                {
                    name: "materialWidth",
                    fieldLabel: "宽幅",
                    xtype: "textfield",
                },
                {
                    name: "materialWeight",
                    fieldLabel: "纺织克重",
                    xtype: "textfield",
                    margin: '0 0 0 20',
                }
            ]
        },
        {
            xtype: "container",
            layout: "hbox",
            margin: '0 0 5',
            items: [
                {
                    name: "materialPrice",
                    fieldLabel: "价格",
                    xtype: "textfield",
                },
                {
                    name: "materialColor",
                    fieldLabel: "颜色",
                    xtype: "textfield",
                    margin: '0 0 0 20',
                }
            ]
        }, {
            name: "materialDescription",
            xtype: "textfield",
            labelWidth: 100,
            fieldLabel: "物料描述",
            flex: 1,
            margin: '0 18 0 0',
        }       
    ]
});