Ext.define("app.view.imms.material.material.MaterialMediaGrid", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_material_MaterialMediaGrid",
    uses: ["app.model.imms.material.MaterialMediaModel", "app.store.imms.material.MaterialMediaStore",
        "app.ux.dbgrid.DbGridToolbar", "app.ux.data.FilterOperation"],

    hideDefaultPagebar: true,
    hideSearchBar: true,

    columns: [
        { dataIndex: "mediaName", text: "名称", width: 200 },
        { dataIndex: "mediaType", text: "类型", width: 80 },
        { dataIndex: "mediaDescription", text: "描述", flex: 1 },
    ],

    constructor: function (config) {
        var configBase = {
            store: Ext.create({ xtype: 'app_store_imms_material_MaterialMediaStore', autoLoad: false })
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },

    setToolbarEnabled: function (enabled) {
        var toolbar = this.down("dbgridtoolbar");
        toolbar.setEnabled(enabled);
    },

    beforeInsert: function () {
        var me = this;
        var filterOperation = Ext.create("app.ux.data.FilterOperation", {
            winWidth: 500,
            winHeight: 400,
            store: me.filterStore,
            columns: [
                
            ],
            callback: function (grid, selectedRecords) {

            }
        });

        return false;
    },

    beforeEdit: function () {
        //物料多媒体不可以修改，只可以新增、删除
        return false;
    }
});