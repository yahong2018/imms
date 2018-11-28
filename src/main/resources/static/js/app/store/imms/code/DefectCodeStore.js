Ext.define("app.store.imms.code.DefectCodeStore",{
    extend:"app.store.BaseTreeStore",
    model: 'app.model.imms.code.DefectCodeModel',
    alias:'widget.app_store_imms_code_DefectCodeStore',
     
    dao:{
        deleteUrl: '/imms/code/defectCode/delete.handler',
        insertUrl: '/imms/code/defectCode/create.handler',
        updateUrl: '/imms/code/defectCode/update.handler',
        selectUrl: '/imms/code/defectCode/getAll.handler',
    },     
    listeners:{
        load:function(){
            this.sort('defectCodeNo','ASC');
        }
    }
});