Ext.define('app.model.admin.SystemRoleModel',{
    extend: 'Ext.data.Model',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "roleId", dbFieldName: 'role_id', type: "string", unique: true },
        { name: "roleName", dbFieldName: 'role_name', type: "string" }
    ],
    idProperty: 'roleId'        
});