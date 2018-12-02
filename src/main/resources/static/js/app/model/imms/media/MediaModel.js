Ext.define("app.model.imms.media.MediaModel",{
    extend: 'Ext.data.Model',
    requires: ["app.model.EmptyGenerator"],
    identifier:'empty',
    fields:[
        { name: "mediaId", dbFieldName: 'media_id', type: "string", unique: true },   
        { name: "mediaName", dbFieldName: 'media_name', type: "string" },   
        { name: "mediaType", dbFieldName: 'media_type', type: "string" },   
        { name: "mediaUrl", dbFieldName: 'media_url', type: "string" },   
        { name: "mediaSize", dbFieldName: 'media_size', type: "int" },   
        { name: "mediaDescription", dbFieldName: 'media_description', type: "string" },   
        { name: "mediaDataSource", dbFieldName: 'media_data_source', type: "string" },   
    ],
    idProperty:"mediaId"
});