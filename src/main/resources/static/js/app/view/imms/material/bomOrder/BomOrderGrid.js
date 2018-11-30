Ext.define("app.view.imms.material.bomOrder.BomOrderGrid", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_bomOrder_BomOrderGrid",
    uses: ['app.view.imms.material.bomOrder.BomOrderDetailForm'],

    hideDefaultToolbar: true,
    columns: [
        {
            text: 'BOM单号',
            dataIndex: 'bomOrderNo',
            width: 100
        },
        {
            text: 'BOM类型',
            dataIndex: 'bomOrderType',
            width: 100,
        }
    ],

    constructor:function(config){
        var configBase = {          
           detailFormClass: 'app_view_imms_material_bomOrder_BomOrderDetailForm',         
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },

    createDetailWindowFun: function (config) {
        debugger;
        var form = this.up('app_view_imms_material_bomOrder_BomOrder').down('app_view_imms_material_bomOrder_BomOrderDetailForm');
        return form;
    }
});