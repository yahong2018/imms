Ext.define('app.model.imms.code.SizeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "sizeId", dbFieldName: 'size_id', type: "string", unique: true },
        { name: "sizeNo", dbFieldName: 'size_no', type: "string",unique:true },
        { name: "sizeName", dbFieldName: 'size_name', type: "string" },
        { name: "sizeDescription", dbFieldName: 'size_description', type: "string" },
        { name: "parentSizeId", dbFieldName: 'parent_size_id', type: "string" },
    ],
    idProperty: 'sizeId'
});