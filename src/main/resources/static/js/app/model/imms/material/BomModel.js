Ext.define('app.model.imms.material.BomModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier: 'empty',
    fields: [
        { name: "bomId", dbFieldName: 'bom_id', type: "string", unique: true },
        { name: "bomOrderId", dbFieldName: 'bom_order_id', type: "string" },
        { name: "bomOrderNo", dbFieldName: 'bom_order_no', type: "string" },
        { name: "componentMaterialId", dbFieldName: 'component_material_id', type: "string" },
        { name: "componentMaterialNo", dbFieldName: 'component_material_no', type: "string" },
        { name: "componentMaterialName", dbFieldName: 'component_material_name', type: "string" },

        { name: "componentAbstractMaterialId", dbFieldName: 'component_abstract_material_id', type: "string" },
        { name: "componentAbstractMaterialNo", dbFieldName: 'component_abstract_material_no', type: "string" },
        { name: "componentAbstractMaterialName", dbFieldName: 'component_abstract_material_name', type: "string" },

        { name: "componentQty", dbFieldName: 'component_qty', type: "float" },

        { name: "componentMaterialUomId", dbFieldName: 'component_material_uom_id', type: "string" },
        { name: "componentMaterialUomNo", dbFieldName: 'component_material_uom_no', type: "string" },
        { name: "componentMaterialUomName", dbFieldName: 'component_material_uom_name', type: "string" },

        { name: "componentTypeNo", dbFieldName: 'component_type_no', type: "string" },
        { name: "componentTypeName", dbFieldName: 'component_type_name', type: "string" },

        { name: "parentBomId", dbFieldName: 'parent_bom_id', type: "string" },

        { name: "componentMaterialMatchRuleId", dbFieldName: 'component_material_match_rule_id', type: "string" },
        { name: "componentMaterialMatchRuleNo", dbFieldName: 'component_material_match_rule_no', type: "string" },
        { name: "componentMaterialMatchRuleName", dbFieldName: 'component_material_match_rule_name', type: "string" },

        { name: "ifMainFabric", dbFieldName: 'if_main_fabric', type: "boolean" },

        { name: "bomDataSource", dbFieldName: 'bom_data_source', type: "string" },
        {
            name: "componentMaterialUomNoAndName", dbFieldName: "componentMaterialUomNoAndName", mapping: function (data) {
                return data.componentMaterialUomName + "(" + data.componentMaterialUomNo + ")";
            }
        }
    ],
    idProperty: 'bomId'
});