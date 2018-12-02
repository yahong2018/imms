Ext.define("app.model.imms.material.MaterialMediaModel",{
    extend:"Ext.data.Model",
    requires: ["app.model.EmptyGenerator"],
    identifier: 'empty',
    fields: [
        { name: "materialMediaId", dbFieldName: 'material_media_id', type: "string", unique: true },
        { name: "materialMediaMediaId", dbFieldName: 'material_media_media_id', type: "string" },
        { name: "materialMediaMaterialId", dbFieldName: 'material_media_material_id', type: "string" },

        { name: "mediaType", dbFieldName: 'media_type', type: "string" },
        { name: "mediaUrl", dbFieldName: 'media_url', type: "string" },
        { name: "mediaName", dbFieldName: 'media_name', type: "string" },

        { name: "mediaSize", dbFieldName: 'media_size', type: "string" },
        { name: "mediaDescription", dbFieldName: 'media_description', type: "string" },
        { name: "mediaDataSource", dbFieldName: 'media_data_source', type: "string" },
    ],
    idProperty: 'materialMediaId'
});