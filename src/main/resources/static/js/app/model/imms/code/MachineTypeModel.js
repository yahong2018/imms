Ext.define('app.model.imms.code.MachineTypeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "recordId", dbFieldName: 'record_id', type: "string", unique: true },
        { name: "machineTypeNo", dbFieldName: 'machine_type_no', type: "string",unique:true },
        { name: "machineTypeName", dbFieldName: 'machine_type_name', type: "string" },
        { name: "codePath", dbFieldName: 'code_path', type: "string" },
        { name: "namePath", dbFieldName: 'name_path', type: "string" },
        { name: "machineTypeDescription", dbFieldName: 'machine_type_description', type: "string" },
        { name: "parentMachineTypeId", dbFieldName: 'parent_machine_type_id', type: "string" },
    ],
    idProperty: 'recordId'
});