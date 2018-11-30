Ext.define('app.view.imms.material.bomOrder.BomOrder', {
    extend: 'Ext.panel.Panel',
    xtype:'app_view_imms_material_bomOrder_BomOrder',
    requires: ["app.ux.dbgrid.DbGridToolbar","app.view.imms.material.bomOrder.BomOrderGrid"],
    uses:['app.view.imms.material.bomOrder.BomOrderDetailForm'],
    layout: 'fit',
    items: [
        {
            xtype: 'panel',
            frame: false,
            layout: 'border',
            items: [
                {
                    region:"west",
                    xtype: "app_view_imms_material_bomOrder_BomOrderGrid",
                    width:300
                },{
                    region:'center',
                    xtype:'app_view_imms_material_bomOrder_BomOrderDetailForm',
                    frame:true,
                }
            ],        
        }
    ],    

    initComponent:function(){       
        this.callParent(arguments);  

        var me = this;
        var grid = me.down("app_view_imms_material_bomOrder_BomOrderGrid");
        var config = {
            xtype: 'dbgridtoolbar',                
            dbGrid: grid
        };  

        var defaultToolbar = Ext.create(config);
        me.dockedItems.add('toolbar',defaultToolbar);           
    }
});