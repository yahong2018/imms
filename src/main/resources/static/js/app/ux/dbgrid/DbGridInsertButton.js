Ext.define('app.ux.dbgrid.DbGridInsertButton', {
    extend: 'app.ux.dbgrid.DbGridButton'
    , xtype: 'dbgridinsertbutton'
    , constructor: function (config) {
        var configBase = {
            text: '新增'
            , glyph: 0xf067
             ,tooltip:'新建一笔数据'
            , handler: function () {               
                if (this.getGrid().doInsert) {
                    this.getGrid().doInsert();
                }
            }
        };
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    }

});