Ext.define('app.ux.dbgrid.DetailWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.detailwindow',
    requires:["app.ux.dbgrid.SaveOperation"],
    mixins:["app.ux.dbgrid.SaveOperation"],    

    modal: true,
    maximizable: true,
    minimizable: true,
    buttons: [
        '->'
        , {
            text: '保存',
            buttonName:'save',
            handler: function () {
                var me = this.up('detailwindow');
                me.doSave();
            }
        }, {
            text: '保存并新增',
            buttonName:'saveAndInsert',
            handler: function () {
                var me = this.up('detailwindow');
                me.doSave(true);
            }
        }
        , {
            text: '取消', handler: function () {
                var me = this.up('detailwindow');
                me.close();
                me.destroy();
                delete me;
                me = null;
            }
        }
    ],    
});