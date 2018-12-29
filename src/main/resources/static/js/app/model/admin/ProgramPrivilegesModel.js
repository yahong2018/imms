Ext.define('app.model.admin.ProgramPrivilegesModel', {
	extend:'Ext.data.Model',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    identifier:'empty',
    fields:[
        { name: "recordId", dbFieldName: 'record_id', type: "string"},
        { name: "programId", dbFieldName: 'program_id', type: "string" },
        { name: "privilegeCode", dbFieldName: 'privilege_code', type: "string" },
        { name: "privilegeName", dbFieldName: 'privilege_name', type: "string" },
    ],
    idProperty:'recordId'
});