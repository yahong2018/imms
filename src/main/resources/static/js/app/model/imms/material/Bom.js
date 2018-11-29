Ext.define('app.model.imms.material.BomModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "rowId", dbFieldName: 'row_id', type: "string", unique: true },
        { name: "bomOrderId", dbFieldName: 'bom_order_id', type: "string",unique:true },
        { name: "componentMaterialId", dbFieldName: 'component_material_id', type: "string" },
        { name: "componentAbstractMaterialId", dbFieldName: 'component_abstract_material_id', type: "string" },        
        { name: "qty", dbFieldName: 'qty', type: "float" },      
        { name: "componentMaterialUom", dbFieldName: 'component_material_uom', type: "string" },      
        { name: "type", dbFieldName: 'type', type: "string" },      
        { name: "parentId", dbFieldName: 'parent_id', type: "string" },  
        { name: "materialMatchRuleId", dbFieldName: 'material_match_rule_id', type: "string" },  
        { name: "ifMainFabric", dbFieldName: 'if_main_fabric', type: "boolean" },  
        { name: "source", dbFieldName: 'source', type: "string" },  
    ],
    idProperty: 'rowId'
});