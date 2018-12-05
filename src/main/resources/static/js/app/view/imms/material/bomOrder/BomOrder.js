Ext.define('app.view.imms.material.bomOrder.BomOrder', {
    extend: 'Ext.panel.Panel',
    xtype: 'app_view_imms_material_bomOrder_BomOrder',
    requires: ["app.ux.dbgrid.DbGridToolbar", "app.view.imms.material.bomOrder.BomOrderGrid",
        "app.view.imms.material.bomOrder.BomGrid", "app.ux.filterButton.FilterButton",
        "app.store.imms.code.UomStore", "app.store.imms.material.MaterialStore"],
    uses: ['app.view.imms.material.bomOrder.BomOrderDetailForm'],

    layout: 'fit',
    items: [
        {
            xtype: 'panel',
            frame: false,
            layout: 'border',
            items: [
                {
                    region: "west",
                    xtype: "app_view_imms_material_bomOrder_BomOrderGrid",
                    width: 400
                }, {
                    region: 'center',
                    xtype: "app_view_imms_material_bomOrder_BomGrid"
                }
            ],
        }
    ],

    initComponent: function () {
        this.callParent(arguments);

        var me = this;
        var grid = me.down("app_view_imms_material_bomOrder_BomOrderGrid");
        var config = {
            xtype: 'dbgridtoolbar',
            dbGrid: grid
        };

        var defaultToolbar = Ext.create(config);
        me.dockedItems.add('toolbar', defaultToolbar);
    }
});