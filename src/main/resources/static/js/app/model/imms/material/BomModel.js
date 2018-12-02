Ext.define('app.model.imms.material.BomModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
        { name: "bomId", dbFieldName: 'bom_id', type: "string", unique: true },        
        { name: "componentMaterialId", dbFieldName: 'component_material_id', type: "string" },
        { name: "componentAbstractMaterialId", dbFieldName: 'component_abstract_material_id', type: "string" },        
        { name: "componentQty", dbFieldName: 'component_qty', type: "float" },      
        { name: "componentMaterialUom", dbFieldName: 'component_material_uom', type: "string" },      
        { name: "bomType", dbFieldName: 'bomType', type: "string" },      
        { name: "parentMaterialId", dbFieldName: 'parent_material_id', type: "string" },  
        { name: "materialMatchRuleId", dbFieldName: 'material_match_rule_id', type: "string" },  
        { name: "ifMainFabric", dbFieldName: 'if_main_fabric', type: "boolean" },  
        { name: "bomDataSource", dbFieldName: 'bom_data_source', type: "string" },  
    ],
    idProperty: 'bomId'
});