Ext.define("app.store.imms.code.SizeStore",{
    extend:"app.store.BaseTreeStore",
    model: 'app.model.imms.code.SizeModel',
    alias:'widget.app_store_imms_code_SizeStore',
     
    dao:{
        deleteUrl: '/imms/code/size/delete.handler',
        insertUrl: '/imms/code/size/create.handler',
        updateUrl: '/imms/code/size/update.handler',
        selectUrl: '/imms/code/size/getAll.handler',
    },     
    listeners:{
        load:function(){
            this.sort('sizeNo','ASC');
        }
    }
});