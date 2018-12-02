Ext.define("app.view.imms.material.material.Material", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_material_Material",

    requires: ["app.store.imms.material.MaterialStore", "app.model.imms.material.MaterialModel"],
    uses:["app.view.imms.material.material.MaterialDetailForm"],

    columns: [
        { dataIndex: "materialNo", text: '物料编码', width: 100 },
        { dataIndex: "materialName", text: '物料名称', width: 150 },
        {
            dataIndex: "materialTypeNo", text: '物料类型', width: 200, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("materialTypeName") + "(" + value + ")";
            }
        },
        {
            name: "uomNo", text: '计量单位', width: 150, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("uomeName") + "(" + value + ")";
            }
        },
        { name: "width", text: '宽幅', width: 100 },
        { name: "weight", text: '纺织克重', width: 100 },
        {
            name: "sizeNo", text: '尺码组', width: 150, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("sizeName") + "(" + value + ")";
            }
        },
        { name: "price", text: '价格'},
        { name: "color", text: '颜色'},
        { name: "description", text: '物料描述', width:300}        
    ],

    constructor:function(config){
        var configBase = {
            store: Ext.create({xtype:'app_store_imms_material_MaterialStore'}),
            detailFormClass: 'app_view_imms_material_material_MaterialDetailForm',
            detailWindowTitle: '物料',
         }
         Ext.applyIf(config,configBase);
 
         this.callParent(arguments);
    }
});