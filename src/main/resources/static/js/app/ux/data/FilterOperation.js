Ext.define("app.ux.data.FilterOperation",{
    xtype:"app_ux_data_FilterOperation",
    uses: ["Ext.window.Window", "app.ux.dbgrid.DbGrid", "app.ux.dbgrid.DbGridToolbar"],

    /**
     * 配置项：columns
     *   用途：选择框中grid的columns配置项
     */

    /**
     * 配置项:winWidth
     *  用途：窗体的宽度，默认为500
     */

    /**
     * 配置项：winHeight
     *   用途：窗体高度，默认为400
     */

    /**
     * 配置项：store
     *   用途：grid的store
     */

    /**
     * 配置项:callback
     *   参数:  grid              在记录选择窗体中的grid
     *         selectedRecords    在记录选择窗体中所选择的记录
     * 
     *   用途：选择框关闭以后，会调用本函数。
     */

    constructor: function (config) {
        var configBase = {
            winHeight: 400,
            winWidth: 500,
            callback: function () { }
        };

        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },

    showFilterWindow:function(){
        var me = this;
        var win = Ext.create("Ext.window.Window", {
            modal: true,
            width: this.winWidth,
            height: this.winHeight,
            title: "数据查找",
            layout:"fit",
            items: [
                {
                    xtype: "dbgrid",
                    columns: me.columns,
                    store: me.store,
                    dockedItems: [{
                        xtype: "dbgridtoolbar",
                        hideInsert: true,
                        hideEdit: true,
                        hideDelete: true
                    }],
                    hideDefeaultPagebar: false
                }
            ],
            bbar: [
                '->',
                {
                    text: "确定",
                    handler: function () {
                        var grid = win.down('dbgrid');
                        var selectedRecords = grid.getSelectionModel().getSelection();
                        me.callback(grid, selectedRecords);

                        win.close();
                        win.destroy();
                        win = null;
                    }
                },
                {
                    text: "取消",
                    handler: function () {
                        win.close();
                        win.destroy();
                        win = null;
                    }
                }
            ]
        });
        win.show();
    }
});