Ext.define('app.model.imms.code.UomModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "uomNo", dbFieldName: 'uom_no', type: "string",unique:true },
        { name: "uomName", dbFieldName: 'uom_name', type: "string" },
        { name: "description", dbFieldName: 'description', type: "string" },        
    ],
    idProperty: 'rowId'
});