Ext.define('app.model.imms.code.MachineTypeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "machineTypeNo", dbFieldName: 'machine_type_no', type: "string",unique:true },
        { name: "machineTypeName", dbFieldName: 'machine_type_name', type: "string" },
        { name: "description", dbFieldName: 'description', type: "string" },
        { name: "parentMachineTypeId", dbFieldName: 'parent_machine_type_id', type: "string" },
    ],
    idProperty: 'rowId'
});