Ext.define("app.ux.dbgrid.DataOperation", {
    xtype: 'dataoperation',

    requires: ['app.ux.dbgrid.DbGridToolbar'],
    uses: ['app.ux.dbgrid.DetailWindow', 'Ext.util.Base64', 'app.ux.advancedSearch.SearchWindow','app.ux.Utils'],

    getInitConfig: function () {
        var me = this;
        return {
            columnLines: true,
            style: 'padding-left:5px;',
            insertDetailWindowClass: 'app.ux.dbgrid.DetailWindow',
            editDetailWindowClass: 'app.ux.dbgrid.DetailWindow',
            frame: true,
            listeners: {
                rowdblclick: function (grid, rowindex, e) {
                    me.showDetailWindow(grid, rowindex, e);
                }
            }
        };
    },

    internalInitComponent: function () {
        var haseDefaultPagebar = false;
        var hasDefaultToolbar = false;
        var me = this;

        this.selModel = new Ext.selection.CheckboxModel();

        if (me.dockedItems) {
            for (var i = 0; i < me.dockedItems.length; i++) {
                var item = me.dockedItems[i];
                if (item.xtype == "pagingtoolbar") {
                    haseDefaultPagebar = true;
                    continue;
                }

                if (item.xtype == "dbgridtoolbar") {
                    hasDefaultToolbar = true;
                    item.dbGrid = this;
                    continue;
                }
            }
        } else {
            me.dockedItems = [];
        }

        if (!haseDefaultPagebar && !me.hideDefeaultPagebar) {
            me.dockedItems.unshift(
                Ext.create({
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    store: me.store,
                    displayInfo: true,
                })
            );
        }      

        if (!hasDefaultToolbar && !me.hideDefaultToolbar) {
            var config = {
                xtype: 'dbgridtoolbar',                
                dbGrid: this
            };  

            var defaultToolbar = Ext.create(config);
            me.dockedItems.push(defaultToolbar);
        }
    },

    /*
    applyPrivileges: function (config) {
        debugger;
        var privilegeList = app.ux.GlobalVars.currentLogin.privilegeList;
        var programId = config.programId;
        var model = config.model;
        var grid = this;

        for (var i = 0; i < privilegeList.length; i++) {
            if (privilegeList[i].programId != programId) {
                continue;
            }
            debugger;

            var privilege = privilegeList[i];
            var actionButton = grid.down('[privilege="' + privilege.privilegeId + '"]');
            if (actionButton) {
                actionButton.setDisabled(false);
            }
        }
    },
    */

    doInsert: function () {
        var grid = this;
        if (this.beforeInsert) {
            if (this.beforeInsert() === false) {
                return;
            }
        }

        var deailWindow = Ext.create(this.insertDetailWindowClass, {
            isNew: true,
            title: this.detailWindowTitle,
            store: this.store,
            listGrid: grid,
            items: [{
                xtype: this.detailFormClass,
            }]
        });
        var form = deailWindow.down(this.detailFormClass);
        var record = this.store.createModel({});

        if (form.beforeLoadRecord) {
            form.beforeLoadRecord({ isNew: true, record: record });
        }

        form.loadRecord(record);

        if (form.afterLoadRecord) {
            form.afterLoadRecord({ isNew: true, record: record });
        }

        var currentTopWindow = Ext.app.Application.instance.getMainView().down('maincenter').getActiveTab();
        var programId = currentTopWindow.menuData.get('programId');
        var canInsert = app.ux.Utils.hasPrivilege({programId:programId,privilegeId:"INSERT"});
        if(!canInsert){
            deailWindow.down('[buttonName="save"]').setDisabled(true);
            deailWindow.down('[buttonName="saveAndInsert"]').setDisabled(true);
        }

        deailWindow.show();
    },
    doEdit: function () {
        var grid = this;
        var record = this.getSelectionModel().getSelection();
        if (!record || record.length == 0) {
            Ext.MessageBox.alert("系统提示", "请先选择一条待编辑记录！");
            return;
        }

        record = record[0];
        if (this.beforeEdit) {
            if (this.beforeEdit(record) === false) {
                return;
            }
        }

        var deailWindow = Ext.create(this.editDetailWindowClass, {
            isNew: false,
            title: this.detailWindowTitle,
            store: this.store,
            listGrid: grid,
            items: [{
                xtype: this.detailFormClass,
            }]
        });
        var form = deailWindow.down(this.detailFormClass);
        if (form.beforeLoadRecord) {
            form.beforeLoadRecord({ isNew: false, record: record });
        }
        form.loadRecord(record);

        var idField = form.down('[name="' + record.getIdProperty() + '"]');
        if (idField) {
            idField.readOnly = true;
        }
        if (form.afterLoadRecord) {
            form.afterLoadRecord({ isNew: false, record: record });
        }

        var currentTopWindow = Ext.app.Application.instance.getMainView().down('maincenter').getActiveTab();
        var programId = currentTopWindow.menuData.get('programId');
        var canUpdate = app.ux.Utils.hasPrivilege({programId:programId,privilegeId:"UPDATE"});
        if(!canUpdate){
            deailWindow.down('[buttonName="save"]').setDisabled(true);
            deailWindow.down('[buttonName="saveAndInsert"]').setDisabled(true);
        }

        deailWindow.show();
    },

    showDetailWindow: function (grid, rowindex, e) {
        var grid = this;
        var record = this.getSelectionModel().getSelection();
        if (!record || record.length == 0) {
            return;
        }

        record = record[0];
        var deailWindow = Ext.create(this.editDetailWindowClass, {
            isNew: false,
            title: this.detailWindowTitle,
            store: this.store,
            listGrid: grid,
            items: [{
                xtype: this.detailFormClass,
            }]
        });
        var form = deailWindow.down(this.detailFormClass);
        form.loadRecord(record);

        var idField = form.down('[name="' + record.getIdProperty() + '"]');
        if (idField) {
            idField.readOnly = true;
        }

        /*
        var model = this.store.getModel();
        for (var i = 0; i < model.fields.length; i++) {
            var dbField = model.fields[i];
            var field = form.down('[name="' + dbField.name + '"]');
            if (field) {
                field.readOnly = true;
            }
        }
        */

        if (form.afterLoadRecord) {
            form.afterLoadRecord({ isNew: false, record: record });
        }

        var currentTopWindow = Ext.app.Application.instance.getMainView().down('maincenter').getActiveTab();
        var programId = currentTopWindow.menuData.get('programId');
        debugger;
        var canUpdate = app.ux.Utils.hasPrivilege({programId:programId,privilegeId:"UPDATE"});
        if(!canUpdate){
            deailWindow.down('[buttonName="save"]').setDisabled(true);
            deailWindow.down('[buttonName="saveAndInsert"]').setDisabled(true);
        }

        deailWindow.show();
    },

    doSearch: function (column, operator, value) {
        var grid = this;
        var expr = "";
        if (column != null && operator != null && value != '' && value != null) {
            var model = grid.store.getModel();
            if (model == null) {
                return;
            }
            var fieldName = column.get('dataIndex');
            if (fieldName == null) {
                return;
            }

            var field = model.getField(fieldName);
            if (field == null) {
                return;
            }
            if (field.dbFieldName != null) {
                fieldName = field.dbFieldName;
            }

            expr = fieldName + ' ' + operator.get('abbr');
            var fieldType = field.type;
            if (fieldType == 'string' || fieldType == 'date') {
                expr = expr + "'" + value + "'";
            } else {
                expr = expr + value;
            }
            expr = Ext.util.Base64.encode(expr);
            expr = 'filterExpr=' + expr;
        }
        if (grid.getStore().getProxy().DefaultUrl == null) {
            grid.getStore().getProxy().DefaultUrl = grid.getStore().getProxy().url;
        }
        var url = grid.getStore().getProxy().DefaultUrl;
        if (url.indexOf("?") == -1) {
            url += "?";
        }
        url += expr;
        grid.getStore().getProxy().url = url;
        grid.getStore().load();
    },
    advancedSearch: function () {
        var grid = this;
        Ext.create("app.ux.advancedSearch.SearchWindow", {
            title: "高级查询",
            dbGrid: grid,
        }).show();
    },
    getSelectedRecord: function () {
        var record = this.getSelectionModel().getSelection();
        if (!record || record.length == 0) {
            return null;
        }
        return record[0];
    },

    listeners: {
        destroy: function (me, eOpts) {
            // debugger;            
        }
    }

});