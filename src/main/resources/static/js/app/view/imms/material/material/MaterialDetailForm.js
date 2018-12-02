Ext.define("app.view.imms.material.material.MaterialDetailForm", {
    extend: "Ext.panel.Panel",
    xtype: "app_view_imms_material_material_MaterialDetailForm",
    requires: ["Ext.tab.Panel", "app.view.imms.material.material.MaterialBasicForm", "app.view.imms.material.material.MaterialMediaGrid"],
    uses: ["app.ux.data.DataMode"],

    bodyPadding: 1,
    width: 600,
    items: [
        {
            xtype: 'tabpanel',
            bodyPadding: 5,
            items: [
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
                            xtype: "app_view_imms_material_material_MaterialMediaGrid"
                        }
                    ]
                }
            ]
        }
    ],

    loadRecord: function (record) {
        var form = this.down('app_view_imms_material_material_MaterialBasicForm');
        form.loadRecord(record);
    },
    onRecordLoad: function (config) {
        var dataMode = config.dataMode;
        var record = config.record;
    
        //如果是新增，则要Disabled掉多媒体MaterialMediaGrid的操作
        var enabled = (dataMode != app.ux.data.DataMode.INSERT);
        var mediaGrid = this.down("app_view_imms_material_material_MaterialMediaGrid");
        mediaGrid.setToolbarEnabled(enabled);

        //查找到属于本MterialId的Media
        var expr = "?filterExpr=" + Ext.util.Base64.encode("material_media_material_id='" + record.get("material_id") + "'")        
        var url = mediaGrid.getStore().getProxy().url;        
        url += expr;
        mediaGrid.getStore().getProxy().url = url;
        mediaGrid.getStore().load();
    }
});