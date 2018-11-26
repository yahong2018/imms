Ext.define('app.model.admin.ProgramPrivilegesModel', {
	extend:'Ext.data.Model',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    identifier:'empty',
    fields:[
        { name: "programPrivilegeId", dbFieldName: 'program_privilege_id', type: "int", unique: true },
        { name: "programId", dbFieldName: 'program_id', type: "string" },
        { name: "privilegeId", dbFieldName: 'privilege_id', type: "string" },
        { name: "privilegeName", dbFieldName: 'privilege_name', type: "string" },
    ],
    idProperty:'programPrivilegeId'
});