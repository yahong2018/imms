Ext.define('app.model.imms.code.UomModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "recordId", dbFieldName: 'record_id', type: "string", unique: true },
        { name: "uomNo", dbFieldName: 'uom_no', type: "string",unique:true },
        { name: "uomName", dbFieldName: 'uom_name', type: "string" },
        { name: "uomDescription", dbFieldName: 'uom_description', type: "string" },        
    ],
    idProperty: 'recordId'
});