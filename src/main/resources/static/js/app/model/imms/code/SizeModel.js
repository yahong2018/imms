Ext.define('app.model.imms.code.SizeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "sizeNo", dbFieldName: 'size_no', type: "string",unique:true },
        { name: "sizeName", dbFieldName: 'size_name', type: "string" },
        { name: "description", dbFieldName: 'description', type: "string" },
        { name: "parentSizeId", dbFieldName: 'parent_size_id', type: "string" },
    ],
    idProperty: 'rowId'
});