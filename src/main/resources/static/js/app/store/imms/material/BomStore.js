Ext.define("app.store.imms.material.BomStore",{
    extend:"app.store.BaseStore",
    model: 'app.model.imms.material.BomModel',
    alias:'widget.app_store_imms_material_BomStore',
     
    dao:{
        deleteUrl: '/imms/code/bom/delete.handler',
        insertUrl: '/imms/code/bom/create.handler',
        updateUrl: '/imms/code/bom/update.handler',
        selectUrl: '/imms/code/bom/getAll.handler',
    }
});