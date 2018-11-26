Ext.define('app.ux.Utils', {
    uses:['Ext.window.MessageBox','Ext.Ajax'],
    singleton: true,

    ajaxRequest: function (config) {
        var me = config;
        var configBase = {
            success: function (response, opts) {
                var result = Ext.decode(response.responseText);
                if (typeof result == "string") {
                    result = Ext.decode(result);
                }
                if (me.successCallback) {
                    me.successCallback(result, response, opts);
                }
            }, failure: function (response, opts) {
                if (!me.silence) {
                    //debugger;
                    var message = response.responseText.trim().replace("\n","<br>");                   
                    Ext.MessageBox.show({
                        title: '系统提示',
                        msg: message,
                        buttons: Ext.MessageBox.OK,
                        icon: Ext.MessageBox.ERROR,
                        fn: function () {
                            if(me.failureCallback){
                                me.failureCallback(arguments);
                            }
                        }
                    });
                }
            }
        }

        Ext.applyIf(config,configBase);

        Ext.Ajax.request(config);
    },

    verifySelection:function(grid,callback){
        var record = grid.getSelectionModel().getSelection();
        if (!record || record.length == 0) {
            Ext.MessageBox.alert("系统提示", "请先选择一条待编辑记录！");
            return;
        }
        record = record[0];
        if(callback){
            callback(record);
        }
    },
    applyPrivileges: function (config) {
        debugger;
        var privilegeList = app.ux.GlobalVars.currentLogin.privilegeList;
        var programId = config.programId;
        var model = config.model;
        var comp = config.component;

        for (var i = 0; i < privilegeList.length; i++) {
            if (privilegeList[i].programId != programId) {
                continue;
            }
            debugger;

            var privilege = privilegeList[i];
            var actionButton = comp.down('[privilege="' + privilege.privilegeId + '"]');
            if (actionButton) {
                actionButton.setDisabled(false);
            }
        }
    },

    hasPrivilege:function(config){
        var privilegeList = app.ux.GlobalVars.currentLogin.privilegeList;
        var privilegeId = config.privilegeId;
        var programId = config.programId;

        for (var i = 0; i < privilegeList.length; i++) {
            if (privilegeList[i].programId == programId && privilegeList[i].privilegeId == privilegeId) {
                return true;
            }            
        }

        return false;
    },
});