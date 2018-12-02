Ext.define("app.store.imms.material.MaterialStore",{
    extend:"app.store.BaseStore",
    model: 'app.model.imms.material.MaterialModel',
    alias:'widget.app_store_imms_material_MaterialStore',
     
    dao:{
        deleteUrl: '/imms/material/material/delete.handler',
        insertUrl: '/imms/material/material/create.handler',
        updateUrl: '/imms/material/material/update.handler',
        selectUrl: '/imms/material/material/getAllByPage.handler',
    }
});