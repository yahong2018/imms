Ext.define("app.view.imms.code.defectCode.DefectCode", {
    extend: "app.ux.dbgrid.TreeGrid",
    xtype: "app_view_imms_code_defectCode_DefectCode",
    requires:['app.store.imms.code.DefectCodeStore', "app.model.imms.code.DefectCodeModel"],
    uses:["app.view.imms.code.defectCode.DefectCodeDetailForm"],
    rootVisible: false,        
    columns: [
        {
            xtype: 'treecolumn',
            text: '缺陷代码',
            dataIndex: 'defectCodeNo',
            width:250          
        },
        {
            text: '缺陷名称',
            dataIndex: 'defectCodeName',
            width:200,
        },
        {
            text: '缺陷描述',
            dataIndex: 'defectCodeDescription',
            flex:1
        }
    ],
    constructor:function(config){
        var configBase = {
           store: Ext.create({xtype:'app_store_imms_code_DefectCodeStore'}),
           detailFormClass: 'app_view_imms_code_defectCode_DefectCodeDetailForm',
           detailWindowTitle: '缺陷代码',           
        }
        Ext.applyIf(config,configBase);

        this.callParent(arguments);
    },
});