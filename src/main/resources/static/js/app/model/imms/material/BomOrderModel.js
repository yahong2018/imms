Ext.define("app.model.imms.material.BomOrderModel",{
    extend:"Ext.data.Model",
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "bomOrderId", dbFieldName: 'bom_order_Id', type: "string", unique: true },        
        { name: "bomOrderNo", dbFieldName: 'bom_order_no', type: "string",unique:true },
        { name: "bomOrderTypeNo", dbFieldName: 'bom_order_type_no', type: "string" },        
        { name: "bomOrderTypeName", dbFieldName: 'bom_order_type_name', type: "string" }        
    ],
    idProperty: 'bomOrderId'
});