Ext.define("app.store.imms.code.MaterialTypeStore",{
    extend:"app.store.BaseTreeStore",
    model: 'app.model.imms.code.MaterialTypeModel',
    alias:'widget.app_store_imms_code_MaterialTypeStore',
     
    dao:{
        deleteUrl: '/imms/code/materialType/delete.handler',
        insertUrl: '/imms/code/materialType/create.handler',
        updateUrl: '/imms/code/materialType/update.handler',
        selectUrl: '/imms/code/materialType/getAll.handler',
    },     
    listeners:{
        load:function(){
            this.sort('materialTypeNo','ASC');
        }
    }
});