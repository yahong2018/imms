Ext.define('app.view.admin.systemUser.SystemUserDetailForm', {
    extend: 'Ext.form.FormPanel',
    xtype: 'admin_systemUser_SystemUserDetailForm',
    bodyPadding: 5,
    defaults: {
        labelWidth: 70
    },
    width: 400,
    afterSaveAction:"keep",
    items: [{
        name: 'userId',
        fieldLabel: '账户编号',
        allowBlank: false,
        xtype: 'textfield',
        maxLength: 6,
        enforceMaxLength: true,
        width: 150
    }, {
        name: 'userName',
        fieldLabel: '账户名称',
        allowBlank: false,
        xtype: 'textfield',
        maxLength: 20,
        enforceMaxLength: true,
        width: 350
    }, {
        name: 'userStatus',
        fieldLabel: '是否停用',
        allowBlank: false,
        xtype: 'checkbox',
        inputValue: 1
    }, {
        name: 'email',
        fieldLabel: 'Email',
        allowBlank: false,
        xtype: 'textfield',
        width: 350
    }, {
        name: "lastLoginTime",
        xtype: "hidden",
    }, {
        name: 'online',
        xtype: "hidden",
    }],
    
    beforeLoadRecord:function(config){
       
    },
    afterLoadRecord: function (config) {      
    },   
    beforePost:function(config){
        debugger;

        return true;
    },
    afterPost:function(config){
        debugger;

    }
});