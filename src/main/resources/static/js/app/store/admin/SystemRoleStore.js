Ext.define('app.store.admin.SystemRoleStore', {
    extend: 'app.store.BaseStore',
    model: 'app.model.admin.SystemRoleModel',
    alias:'widget.app_store_admin_SystemRoleStore', 
    dao: {
        deleteUrl: '/admin/systemRoles/delete.handler',
        insertUrl: '/admin/systemRoles/insert.handler',
        updateUrl: '/admin/systemRoles/update.handler',
        selectUrl: '/admin/systemRoles/getAll.handler',
    },

    loadRolePrivileges:function(role,callback){        
        var me = this;  //this is the controller
        app.ux.Utils.ajaxRequest({
            url:webRoot+'/admin/systemRoles/getRolePrivileges.handler?roleId='+role.get('roleId'),
            successCallback:function(result, response, opts){
                if(callback){
                    callback.apply(me,[role,result]);                    
                }
            }
        })
    },
    updateRolePrivilege:function(role,privilegeList,callback){
        debugger;

        var me = this;  //this is the controller
        app.ux.Utils.ajaxRequest({
            url:webRoot+'/admin/systemRoles/updateRolePrivileges.handler?roleId='+role.get('roleId'),
            method: 'POST',
            jsonData:privilegeList,
            successCallback:function(result, response, opts){
                if(callback){
                    callback.apply(me,[role,result]);                    
                }
            }
        })        
    }
});