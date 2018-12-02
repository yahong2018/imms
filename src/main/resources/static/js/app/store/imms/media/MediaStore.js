Ext.define("app.store.imms.media.MediaStore",{
    extend:"app.store.BaseStore",
    model:"app.model.imms.media.MediaModel",
    alias:'widget.app_store_imms_media_MediaStore',
     
    dao:{
        deleteUrl: '/imms/media/delete.handler',
        insertUrl: '/imms/media/create.handler',
        updateUrl: '/imms/media/update.handler',
        selectUrl: '/imms/media/getAllByPage.handler',
    }
});