Ext.define("app.view.imms.material.material.MaterialDetailForm", {
    extend: "Ext.tab.Panel",
    xtype: "app_view_imms_material_material_MaterialDetailForm",
    requires: ["app.view.imms.material.material.MaterialBasicForm",
        "app.view.imms.material.material.MaterialMediaGrid"],
    uses: ["app.ux.data.DataMode"],
    margin: '1 0 0 0',
    bodyPadding: 10,
    width: 700,
    height: 440,
    items: [
        {
            title: "基础信息",
            xtype: "app_view_imms_material_material_MaterialBasicForm",
        }, {
            title: "多媒体",
            frame: false,
            xtype: "app_view_imms_material_material_MaterialMediaGrid"
        }
    ],
    getForm:function(){
        var form = this.down('app_view_imms_material_material_MaterialBasicForm');
        return form; 
    },

    loadRecord: function (record) {
        var form = this.down('app_view_imms_material_material_MaterialBasicForm');
        form.loadRecord(record);
    },
    onRecordLoad: function (config) {
        var me = this;
        var dataMode = config.dataMode;
        var record = config.record;

        //如果是新增，则要Disabled掉多媒体MaterialMediaGrid的操作
        var disabled = (dataMode == app.ux.data.DataMode.INSERT);
        var mediaGrid = me.down("app_view_imms_material_material_MaterialMediaGrid");
        mediaGrid.setToolbarDisabled(disabled);

        //查找到属于本materialId的Media
        mediaGrid.materialId = record.get("materialId");
        var expr = "material_media_material_id='" + mediaGrid.materialId + "'";
        mediaGrid.getStore().clearCustomerFilter();
        mediaGrid.getStore().addCustomFilter(expr);
        mediaGrid.getStore().buildFilterUrl();
        mediaGrid.getStore().load();
    }
});