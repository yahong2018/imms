Ext.define('app.model.imms.code.DefectCodeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "defectCodeNo", dbFieldName: 'defect_code_no', type: "string",unique:true },
        { name: "defectCodeName", dbFieldName: 'defect_code_name', type: "string" },
        { name: "description", dbFieldName: 'description', type: "string" },
        { name: "parentDefectId", dbFieldName: 'parent_defect_id', type: "string" },
    ],
    idProperty: 'rowId'
});