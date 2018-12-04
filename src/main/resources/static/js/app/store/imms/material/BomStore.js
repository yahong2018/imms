Ext.define("app.store.imms.material.BomStore",{
    extend:"app.store.BaseTreeStore",
    model: 'app.model.imms.material.BomModel',
    alias:'widget.app_store_imms_material_BomStore',
     
    dao:{
        deleteUrl: '/imms/material/bom/delete.handler',
        insertUrl: '/imms/material/bom/create.handler',
        updateUrl: '/imms/material/bom/update.handler',
        selectUrl: '/imms/material/bom/getAllByPage.handler',
    }
});