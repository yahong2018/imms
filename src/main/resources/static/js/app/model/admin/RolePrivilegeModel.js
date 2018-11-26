Ext.define('app.model.admin.RolePrivilegeModel',{
    extend:'Ext.data.Model',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    fields:[
        { name: "rolePrivilegeId", dbFieldName: 'role_privilege_id', type: "int", unique: true },
        { name: "programPrivilegeId", dbFieldName: 'program_privilege_id', type: "int" },
        { name: "roleId", dbFieldName: 'role_id', type: "string" },
        { name: "programId", dbFieldName: 'program_id', type: "string" },
        { name: "privilegeId", dbFieldName: 'privilege_id', type: "string" }
    ],
    idProperty:'rolePrivilegeId'
});