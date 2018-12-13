Ext.define("app.view.imms.material.bomOrder.BomOrderGrid", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_bomOrder_BomOrderGrid",

    uses: ['app.view.imms.material.bomOrder.BomOrderDetailForm',
        "app.model.imms.material.BomOrderModel",
        "app.store.imms.material.BomOrderStore",
    ],

    hideDefaultToolbar: true,
    columns: [
        {
            text: 'BOM单号',
            dataIndex: 'bomOrderNo',
            width: 150
        },
        {
            text: 'BOM类型',
            dataIndex: 'bomOrderTypeName',
            width: 150,
            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return value + "(" + record.get("bomOrderTypeNo") + ")";
            }
        }
    ],

    constructor: function (config) {
        var me = this;

        var configBase = {
            store: Ext.create({
                xtype: "app_store_imms_material_BomOrderStore",
                listeners: {
                    load: function (s, records, successful, operation, eOpts) {
                        me.onStoreLoad(s, records, successful, operation, eOpts);
                    }
                }
            }),
            detailFormClass: 'app_view_imms_material_bomOrder_BomOrderDetailForm',
            detailWindowTitle: 'Bom 单'
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },

    onStoreLoad: function (store, records, successful, operation, eOpts) {
        if (records.length > 0) {
            this.getSelectionModel().select(0);
        }

        var bomGrid = this.up('app_view_imms_material_bomOrder_BomOrder').down('app_view_imms_material_bomOrder_BomGrid');
        bomGrid.setToolbarDisabled(records.length == 0);
    },

    listeners: {
        beforeselect: function (self, record, index, eOpts) {
            var bomOrderId = record.get("bomOrderId");
            var bomGrid = this.up("app_view_imms_material_bomOrder_BomOrder").down("app_view_imms_material_bomOrder_BomGrid");
            var store = bomGrid.store;
            var expr = "bom_bom_order_id='" + bomOrderId + "'";
            store.clearCustomerFilter();
            store.addCustomFilter(expr);
            store.buildFilterUrl();
            store.load();
        }
    },

});