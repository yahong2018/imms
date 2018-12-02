Ext.define("app.view.imms.code.size.Size", {
    extend: "app.ux.dbgrid.TreeGrid",
    xtype: "app_view_imms_code_size_Size",
    requires:['app.store.imms.code.SizeStore', "app.model.imms.code.SizeModel"],
    uses:["app.view.imms.code.size.SizeDetailForm"],
    rootVisible: false,        
    columns: [
        {
            xtype: 'treecolumn',
            text: '尺码代码',
            dataIndex: 'sizeNo',
            width:250          
        },
        {
            text: '尺码名称',
            dataIndex: 'sizeName',
            width:200,
        },
        {
            text: '尺码描述',
            dataIndex: 'sizeDescription',
            flex:1
        }
    ],
    constructor:function(config){
        var configBase = {
           store: Ext.create({xtype:'app_store_imms_code_SizeStore'}),
           detailFormClass: 'app_view_imms_code_size_SizeDetailForm',
           detailWindowTitle: '尺码',           
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },
});