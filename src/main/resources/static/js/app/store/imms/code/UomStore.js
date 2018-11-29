Ext.define("app.store.imms.code.UomStore",{
    extend:"app.store.BaseStore",
    model: 'app.model.imms.code.UomModel',
    alias:'widget.app_store_imms_code_UomStore',
     
    dao:{
        deleteUrl: '/imms/code/uom/delete.handler',
        insertUrl: '/imms/code/uom/create.handler',
        updateUrl: '/imms/code/uom/update.handler',
        selectUrl: '/imms/code/uom/getAll.handler',
    }
});