Ext.define("app.ux.data.SaveOperation", {
    xtype: 'app_ux_data_SaveOperation',
    uses: ['app.ux.Utils', 'Ext.window.Toast'],

    doSave: function (saveAndNew) {
        var me = this;
        var store = me.store;
        var formCmp = me.getFormCmp();
        var form = formCmp.getForm();
        var grid = me.listGrid;

        if (form.isValid()) {
            var theUrl = store.getUpdateUrl();
            if (me.isNew) {
                theUrl = store.getInsertUrl();
            }
            if (form.owner.beforePost) {
                if (form.owner.beforePost({ isNew: me.isNew, record: form.getRecord() }) === false) {
                    return;
                }
            }

            form.submit({
                url: theUrl,
                success: function (form, action) {
                    store.load({
                        callback: function (records, operation, success) {
                            me.isNew = saveAndNew;
                            var record = store.createModel({});
                            var idProperty = record.getIdProperty();
                            var idField = me.down('[name="' + idProperty + '"]');
                            idField.setReadOnly(!saveAndNew);

                            if (saveAndNew != true) {
                                var index = store.find(idProperty, action.result.data[idProperty]);
                                record = store.getAt(index);
                            }
                            if (form.owner.afterPost) {
                                form.owner.afterPost({ isNew: me.isNew, record: record })
                            }

                            form.loadRecord(record);

                            if (form.onRecordLoad) {
                                form.onRecordLoad({
                                    dataMode: app.ux.data.DataMode.POST,
                                    seq: app.ux.data.DataOperationSeq.AFTER,
                                    record: record
                                });
                            }

                            if (saveAndNew != true && form.owner.afterSaveAction == 'keep') {
                                // Ext.Msg.alert('系统提示', '已成功保存！');
                            } else if (saveAndNew != true) {
                                me.close();
                            }
                            Ext.toast({
                                html: '数据已保存',
                                title: '系统提示',
                                width: 200,
                                align: 't'
                            });
                        }
                    });

                },
                failure: function (form, action) {
                    var message = action.response.responseText.trim().replace("\n", "<br>");
                    Ext.MessageBox.show({
                        title: '系统提示',
                        msg: message,
                        buttons: Ext.MessageBox.OK,
                        icon: Ext.MessageBox.ERROR,
                    });
                }
            });
        }
    }
});