Ext.define('app.ux.dbgrid.DetailWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.detailwindow',
    uses: ['app.ux.Utils','Ext.window.Toast'],

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
    doSave: function (saveAndNew) {
        var me = this;
        debugger;
        var store = me.store;
        var formCmp = me.down('form');
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

                            if (form.owner.beforeLoadRecord) {
                                form.owner.beforeLoadRecord({ isNew: me.isNew, record: record });
                            }
                            form.loadRecord(record);
                            if (form.owner.afterLoadRecord) {
                                form.owner.afterLoadRecord({ isNew: me.isNew, record: record });
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

            /*
             var theOld = form.getRecord();
             var record = form.getValues();
             var store = me.store;
             if (me.isNew) {
                 if (store.beforeInsert) {
                     if (store.beforeInsert(record)===false) {
                         return;
                     }
                 }
                 app.ux.Utils.ajaxRequest({
                     url: store.getInsertUrl(),
                     params:record,
                     method: 'POST',
                     successCallback:function(record){
                         if (store.doAdd) {
                             store.doAdd(record);
                         } else {
                             store.add(record);
                         }
                         store.commitChanges();
                         me.close();
                     }
                 });
             } else {
                 for(var f=0;f<theOld.fields.length;f++){
                     var fieldName = theOld.fields[f].name;
                     if(record[fieldName]=== undefined){
                         record[fieldName] = theOld.get(fieldName);
                         if(record[fieldName] instanceof Date){
                             record[fieldName]=Ext.util.Format.date(theOld.get(fieldName),'Y-m-d H:i:s')
                         }
                     }
                 }
 
                 if (store.beforeUpdate) {
                     if (store.beforeUpdate(record, theOld)===false) {
                         return;
                     }
                 }
 
                 app.ux.Utils.ajaxRequest({
                     url: store.getUpdateUrl(),
                     params:record,
                     method: 'POST',
                     successCallback:function(result){
                         theOld.beginEdit();
                         if (store.doEdit) {
                             store.doEdit(result, theOld);
                         } else {
                             for (var p in result) {
                                 if (theOld.data[p] != null) {
                                     theOld.set(p, result[p]);
                                 }
                             }
                         }
                         theOld.endEdit();
                         store.commitChanges();
 
                         me.close();
                         me.destroy();
                         delete me;
                         me = null;
                     }
                 });
             }  */
        }
    }
});