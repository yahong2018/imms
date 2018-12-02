Ext.define("app.view.imms.code.materialType.MaterialType", {
    extend: "app.ux.dbgrid.TreeGrid",
    xtype: "app_view_imms_code_materialType_MaterialType",
    requires:['app.store.imms.code.MaterialTypeStore', "app.model.imms.code.MaterialTypeModel"],
    uses:["app.view.imms.code.materialType.MaterialTypeDetailForm"],
    rootVisible: false,        
    columns: [
        {
            xtype: 'treecolumn',
            text: '类型代码',
            dataIndex: 'materialTypeNo',
            width:250          
        },
        {
            text: '类型名称',
            dataIndex: 'materialTypeName',
            width:200,
        },
        {
            text: '类型描述',
            dataIndex: 'materialTypeDescription',
            flex:1
        }
    ],
    constructor:function(config){
        var configBase = {
           store: Ext.create({xtype:'app_store_imms_code_MaterialTypeStore'}),
           detailFormClass: 'app_view_imms_code_materialType_MaterialTypeDetailForm',
           detailWindowTitle: '物料类型',           
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },
});