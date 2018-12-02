Ext.define("app.store.imms.material.MaterialMediaStore",{
    extend:"app.store.BaseStore",
    model: 'app.model.imms.material.MaterialMediaModel',
    alias:'widget.app_store_imms_material_MaterialMediaStore',
     
    dao:{
        deleteUrl: '/imms/material/materialMedia/delete.handler',
        insertUrl: '/imms/material/materialMedia/create.handler',
        updateUrl: '/imms/material/materialMedia/update.handler',
        selectUrl: '/imms/material/materialMedia/getAll.handler',
    }
});