Ext.define("app.view.imms.material.material.MaterialDetailForm", {
    extend: "Ext.panel.Panel",
    xtype: "app_view_imms_material_material_MaterialDetailForm",
    requires:["Ext.tab.Panel","app.view.imms.material.material.MaterialBasicForm"],
    uses:["app.ux.data.DataMode"],

    bodyPadding: 1,    
    width: 600,
    items: [
        {
            xtype:'tabpanel',
            bodyPadding:5,
            items:[
                {
                    title: "基础信息",
                    items: [
                        {
                            xtype: "app_view_imms_material_material_MaterialBasicForm",                            
                        }
                    ]
                }, {
                    title: "多媒体",
                    itmes: [
                        {
                            xtype:""
                        }                        
                    ]
                }
            ]
        }
    ],
    
    loadRecord: function (record) {
        var form = this.down('form');
        form.loadRecord(record);
    },
    onRecordLoad:function(config){
        var dataMode = config.dataMode;
        var record = config.record;
        var seq = config.seq;

        //如果是新增，则要Disabled掉DetailGrid的操作
        var enabled = (dataMode==app.ux.data.DataMode.INSERT);
        
    }

});