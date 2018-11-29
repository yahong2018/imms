Ext.define("app.view.imms.material.bom.Bom", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_bom_Bom",
    requires: ['app.store.imms.material.BomStore', "app.model.imms.material.BomModel"],
    uses: ["app.view.imms.material.bom.BomDetailForm"],    
    columns: [
        {
            text: '单位代码',
            dataIndex: 'uomNo',
            width: 250
        },
        {
            text: '单位名称',
            dataIndex: 'uomName',
            width: 200,
        },
        {
            text: '单位描述',
            dataIndex: 'description',
            flex: 1
        }
    ],
    constructor: function (config) {
        if (config.dataAutoLoad == null) {
            config.dataAutoLoad = false;
        }        
        var configBase = {
            store: Ext.create({ xtype: 'app_store_imms_material_BomStore', autoLoad: config.dataAutoLoad }),
            detailFormClass: 'app_view_imms_material_bom_BomDetailForm',
            detailWindowTitle: 'BOM',
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },
    
    loadBomByOrderId: function (orderId) {
        var grid = this;

        if (grid.getStore().getProxy().DefaultUrl == null) {
            grid.getStore().getProxy().DefaultUrl = grid.getStore().getProxy().url;
        }
        var url = grid.getStore().getProxy().DefaultUrl;
        url = url + '?bomOrderId=' + orderId;

        grid.getStore().getProxy().url = url;
        grid.getStore().load();
    }
});