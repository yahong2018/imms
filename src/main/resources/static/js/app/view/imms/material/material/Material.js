Ext.define("app.view.imms.material.material.Material", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_material_Material",

    requires: ["app.store.imms.material.MaterialStore", "app.model.imms.material.MaterialModel",
        "app.ux.filterButton.FilterButton", "app.store.imms.code.MaterialTypeStore",
        "app.store.imms.code.SizeStore","app.store.imms.code.UomStore"],
    uses: ["app.view.imms.material.material.MaterialDetailForm"],

    columns: [
        { dataIndex: "materialNo", text: '物料编码', width: 100 },
        { dataIndex: "materialName", text: '物料名称', width: 150 },
        {
            dataIndex: "materialTypeNo", text: '物料类型', width: 200, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("materialTypeName") + "(" + value + ")";
            }
        },
        {
            dataIndex: "uomNo", text: '计量单位', width: 150, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("uomName") + "(" + value + ")";
            }
        },
        { dataIndex: "materialWidth", text: '宽幅', width: 100 },
        { dataIndex: "materialWeight", text: '纺织克重', width: 100 },
        {
            dataIndex: "sizeNo", text: '尺码组', width: 150, renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {                
                return record.get("sizeName") + "(" + value + ")";
            }
        },
        { dataIndex: "materialPrice", text: '价格',width:80 },
        { dataIndex: "materialColor", text: '颜色' ,width:80},
        { dataIndex: "materialDescription", text: '物料描述', flex:1 }
    ],

    constructor: function (config) {
        var configBase = {
            store: Ext.create({ xtype: 'app_store_imms_material_MaterialStore' }),
            detailFormClass: 'app_view_imms_material_material_MaterialDetailForm',
            detailWindowTitle: '物料',
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    }
});