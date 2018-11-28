Ext.define('app.model.imms.code.MaterialTypeModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "materialTypeNo", dbFieldName: 'material_type_no', type: "string",unique:true },
        { name: "materialTypeName", dbFieldName: 'material_type_name', type: "string" },
        { name: "description", dbFieldName: 'description', type: "string" },
        { name: "parentMaterialTypeId", dbFieldName: 'parent_material_type_id', type: "string" },
    ],
    idProperty: 'rowId'
});