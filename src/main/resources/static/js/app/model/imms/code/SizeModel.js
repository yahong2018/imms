Ext.define('app.model.imms.code.SizeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "recordId", dbFieldName: 'record_id', type: "string", unique: true },
        { name: "sizeNo", dbFieldName: 'size_no', type: "string",unique:true },
        { name: "sizeName", dbFieldName: 'size_name', type: "string" },
        { name: "sizeDescription", dbFieldName: 'size_description', type: "string" },
        { name: "parentSizeId", dbFieldName: 'parent_size_id', type: "string" },
        { name: "sizeNoPath", dbFieldName: 'size_no_path', type: "string" },
        { name: "sizeNamePath", dbFieldName: 'size_name_path', type: "string" },
    ],
    idProperty: 'recordId'
});