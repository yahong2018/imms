Ext.define("app.view.imms.code.uom.Uom", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_code_uom_Uom",
    requires:['app.store.imms.code.UomStore', "app.model.imms.code.UomModel"],
    uses:["app.view.imms.code.uom.UomDetailForm"],        
    columns: [
        {           
            text: '单位代码',
            dataIndex: 'uomNo',
            width:250          
        },
        {
            text: '单位名称',
            dataIndex: 'uomName',
            width:200,
        },
        {
            text: '单位描述',
            dataIndex: 'uomDescription',
            flex:1
        }
    ],
    constructor:function(config){
        var configBase = {
           store: Ext.create({xtype:'app_store_imms_code_UomStore'}),
           detailFormClass: 'app_view_imms_code_uom_UomDetailForm',
           detailWindowTitle: '物料单位',           
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },
});