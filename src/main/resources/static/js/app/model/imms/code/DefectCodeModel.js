Ext.define('app.model.imms.code.DefectCodeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "recordId", dbFieldName: 'record_id', type: "string", unique: true },
        { name: "defectCodeNo", dbFieldName: 'defect_code_no', type: "string",unique:true },
        { name: "codePath", dbFieldName: 'code_path', type: "string" },
        { name: "namePath", dbFieldName: 'name_path', type: "string" },
        { name: "defectCodeName", dbFieldName: 'defect_code_name', type: "string" },
        { name: "defectCodeDescription", dbFieldName: 'defect_code_description', type: "string" },
        { name: "parentDefectCodeId", dbFieldName: 'parent_defect_code_id', type: "string" },
    ],
    idProperty: 'recordId'
});