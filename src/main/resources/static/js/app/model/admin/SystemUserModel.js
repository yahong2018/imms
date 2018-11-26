Ext.define('app.model.admin.SystemUserModel', {
    extend: 'Ext.data.Model',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "userId", dbFieldName: 'user_id', type: "string", unique: true },
        { name: "userName", dbFieldName: 'user_name', type: "string" },
        { name: "password", dbFieldName: 'pwd', type: "string" },
        { name: "userStatus", dbFieldName: 'user_status', type: "int" },
        { name: "email", dbFieldName: 'email', type: "string" },        
        { name: "online", dbFieldName: 'is_online', type: "boolean" },        
        { name: "lastLoginTime", dbFieldName: 'last_login_time', type: 'zhxhDate',dateFormat: 'Y-m-d H:i:s'},
    ],
    idProperty: 'userId'
});