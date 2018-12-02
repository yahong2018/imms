Ext.define('app.ux.dbgrid.DbGridToolbar', {
    extend: 'Ext.toolbar.Toolbar'
    , alias: 'widget.dbgridtoolbar'
    , requires: ['app.ux.dbgrid.DbGridInsertButton', 'app.ux.dbgrid.DbGridEditButton', 'app.ux.dbgrid.DbGridDeleteButton', 'app.ux.dbgrid.DbGridSearchPanel']
    , constructor: function (config) {
        var configBase = {
            dock: 'top',
            insertPrivilege: "INSERT",
            updatePrivilege: "UPDATE",
            deletePrivilege: "DELETE"
        };       
       
        Ext.applyIf(config, configBase);
        config.items = config.items || [];
        var oldLength = config.items.length;

        if (!config.dbGrid.hideInsert) {
            config.items.push({
                xtype: 'dbgridinsertbutton',
                privilege:config.insertPrivilege,
                disabled:true
            });            
        }
        if (!config.dbGrid.hideEdit) {
            config.items.push({
                xtype: 'dbgrideditbutton',
                privilege:config.updatePrivilege,
                disabled:true
            });
        }
        if (!config.dbGrid.hideDelete) {
            config.items.push(
                {
                    xtype: 'dbgriddeletebutton',
                    privilege:config.deletePrivilege,
                    disabled:true
                }
            );
        }

        if (config.dbGrid && config.dbGrid.additionToolbarItems) {
            for (var i = 0; i < config.dbGrid.additionToolbarItems.length; i++) {
                var itemConfig = config.dbGrid.additionToolbarItems[i];
                itemConfig.disabled=true;
                config.items.push(itemConfig)
            }
        }

        if (!config.dbGrid.hideSearchBar) {
            config.items.push("->");
            config.items.push({
                xtype: 'dbgrid_DbGridSearchPanel',           
                dbGrid: config.dbGrid
            });
        }

        this.callParent(arguments);

        var count = config.items.length - oldLength;
        var index = oldLength;
        if(oldLength>0){
            index -=1;
        }
        config.items.splice(index,count);
    }
});