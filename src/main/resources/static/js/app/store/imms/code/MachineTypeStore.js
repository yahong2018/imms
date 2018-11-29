Ext.define("app.store.imms.code.MachineTypeStore",{
    extend:"app.store.BaseTreeStore",
    model: 'app.model.imms.code.MachineTypeModel',
    alias:'widget.app_store_imms_code_MachineTypeStore',
     
    dao:{
        deleteUrl: '/imms/code/machineType/delete.handler',
        insertUrl: '/imms/code/machineType/create.handler',
        updateUrl: '/imms/code/machineType/update.handler',
        selectUrl: '/imms/code/machineType/getAll.handler',
    },     
    listeners:{
        load:function(){
            this.sort('machineTypeNo','ASC');
        }
    }
});