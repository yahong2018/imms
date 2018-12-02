Ext.define("app.view.imms.code.machineType.MachineType", {
    extend: "app.ux.dbgrid.TreeGrid",
    xtype: "app_view_imms_code_machineType_MachineType",
    requires:['app.store.imms.code.MachineTypeStore', "app.model.imms.code.MachineTypeModel"],
    uses:["app.view.imms.code.machineType.MachineTypeDetailForm"],
    rootVisible: false,        
    columns: [
        {
            xtype: 'treecolumn',
            text: '类型代码',
            dataIndex: 'machineTypeNo',
            width:250          
        },
        {
            text: '类型名称',
            dataIndex: 'machineTypeName',
            width:200,
        },
        {
            text: '类型描述',
            dataIndex: 'machineTypeDescription',
            flex:1
        }
    ],
    constructor:function(config){
        var configBase = {
           store: Ext.create({xtype:'app_store_imms_code_MachineTypeStore'}),
           detailFormClass: 'app_view_imms_code_machineType_MachineTypeDetailForm',
           detailWindowTitle: '设备类型',           
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },
});