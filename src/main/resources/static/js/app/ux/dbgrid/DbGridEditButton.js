Ext.define('app.ux.dbgrid.DbGridEditButton', {
    extend: 'app.ux.dbgrid.DbGridButton'
    , xtype: 'dbgrideditbutton'
    , constructor: function (config) {
        var configBase = {
            text: '修改'
            , glyph: 0xf044
             ,tooltip:'修改选定的数据'
            , handler: function () {
                if (this.getGrid().doEdit) {
                    this.getGrid().doEdit();
                }
            }
        };
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    }

});