Ext.define("app.ux.dbgrid.TreeGrid",{
    extend:"Ext.tree.Panel",
    xtype: 'treeGrid',
    alias: 'widget.treeGrid',
    requires:["app.ux.dbgrid.DataOperation","app.ux.dbgrid.DbGridToolbar"],
    mixins:["app.ux.dbgrid.DataOperation"],   

    hideDefeaultPagebar:true,    
    dockedItems:[
        {
            xtype:"dbgridtoolbar",
            hideSearch:true,
        }
    ],

    constructor: function (config) {
        var configBase = this.getInitConfig();
        Ext.applyIf(config, configBase);       
        
        this.callParent(arguments);
    },

    initComponent: function () {
        this.internalInitComponent();

        this.callParent(arguments);
    }
});