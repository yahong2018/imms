Ext.define('app.view.imms.material.bomOrder.BomOrderDetailForm', {
    extend: 'Ext.form.FormPanel',
    xtype: 'app_view_imms_material_bomOrder_BomOrderDetailForm',
    bodyPadding: 5,
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    width: 400,
    items: [
       {
            name: "bomOrderId",
            xtype: "hidden",
        },
        {
            name: 'bomOrderNo',
            fieldLabel: 'BOM单号',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 10,
            enforceMaxLength: true,
        }, {
            name: 'bomOrderTypeNo',
            fieldLabel: 'BOM类型',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 30,
            enforceMaxLength: true,
        }
    ],
    // buttons: [
    //     '->'
    //     , {
    //         text: '保存',
    //         buttonName:'save',
    //         handler: function () {
    //             var me = this.up('app_view_imms_material_bomOrder_BomOrderDetailForm');
    //             me.doSave();
    //         }
    //     }, {
    //         text: '保存并新增',
    //         buttonName:'saveAndInsert',
    //         handler: function () {
    //             var me = this.up('app_view_imms_material_bomOrder_BomOrderDetailForm');
    //             me.doSave(true);
    //         }
    //     }
    //     , {
    //         text: '取消', handler: function () {
    //             var me = this.up('app_view_imms_material_bomOrder_BomOrderDetailForm');
    //             var grid = this.up('app_view_imms_material_bomOrder_BomOrder').down('app_view_imms_material_bomOrder_BomOrderGrid');
    //             var record = grid.getSelectedRecord();
    //             if(record){
    //                 me.loadRecord(record);
    //             }
    //         }
    //     }
    // ], 

    // getFormCmp:function(){
    //     return this;
    // },

    // onRecordLoad:function(config){
    //     var txtBomOrderNo = this.down('[name= "bomOrderNo"]');
    //     txtBomOrderNo.focus();
    // }
});