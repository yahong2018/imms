Ext.define("app.store.imms.material.BomOrderStore",{
    extend:"app.store.BaseStore",
    model: 'app.model.imms.material.BomOrderModel',
    alias:'widget.app_store_imms_material_BomOrderStore',
     
    dao:{
        deleteUrl: '/imms/material/bomOrder/delete.handler',
        insertUrl: '/imms/material/bomOrder/create.handler',
        updateUrl: '/imms/material/bomOrder/update.handler',
        selectUrl: '/imms/material/bomOrder/getAllByPage.handler',
    }
});