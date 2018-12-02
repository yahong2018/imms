Ext.define('app.model.imms.material.MaterialModel', {
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier: 'empty',
    fields: [
        { name: "materialId", dbFieldName: 'material_id', type: "string", unique: true },
        { name: "materialNo", dbFieldName: 'material_no', type: "string", unique: true },
        { name: "materialName", dbFieldName: 'material_name', type: "string" },

        { name: "materialMaterialTypeId", dbFieldName: 'material_material_type_id', type: "string" },
        { name: "materialTypeNo", dbFieldName: 'material_type_no', type: "string" },
        { name: "materialTypeName", dbFieldName: 'material_type_name', type: "string" },

        { name: "materialUomId", dbFieldName: 'material_uom_id', type: "string" },
        { name: "uomNo", dbFieldName: 'uom_no', type: "string" },
        { name: "uomName", dbFieldName: 'uom_name', type: "string" },

        { name: "materialWidth", dbFieldName: 'material_width', type: "float" },
        { name: "materialWeight", dbFieldName: 'material_weight', type: "float" },

        { name: "materialSizeId", dbFieldName: 'material_size_id', type: "string" },
        { name: "sizeNo", dbFieldName: 'size_no', type: "string" },
        { name: "sizeName", dbFieldName: 'weight', type: "string" },
        
        { name: "materialPrice", dbFieldName: 'material_price', type: "float" },
        { name: "materialColor", dbFieldName: 'material_color', type: "string" },
        { name: "materralDescription", dbFieldName: 'material_description', type: "string" }
    ],
    idProperty: 'materialId'
});