Ext.define("app.view.imms.material.material.MaterialMediaGrid", {
    extend: "app.ux.dbgrid.DbGrid",
    xtype: "app_view_imms_material_material_MaterialMediaGrid",
    uses: ["app.model.imms.material.MaterialMediaModel", "app.store.imms.material.MaterialMediaStore",
        "app.ux.dbgrid.DbGridToolbar", "app.ux.data.FilterOperation", "app.store.imms.media.MediaStore",
        "app.ux.Utils", "Ext.window.Toast"],

    hideDefeaultPagebar: true,
    hideSearchBar: true,
    materialId: null,

    columns: [
        { dataIndex: "mediaName", text: "名称", width: 200 },
        { dataIndex: "mediaType", text: "类型", width: 80 },
        { dataIndex: "mediaDescription", text: "描述", flex: 1 },
    ],

    constructor: function (config) {
        var configBase = {
            hideInsert: false,
            hideEdit: true,
            hideDelete: false,
            store: Ext.create({ xtype: 'app_store_imms_material_MaterialMediaStore', autoLoad: false }),
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },

    initComponent: function () {
        this.filterStore = Ext.create({ xtype: "app_store_imms_media_MediaStore", autoLoad: false });
        this.callParent(arguments);
    },


    setToolbarDisabled: function (disabled) {
        var toolbar = this.down("dbgridtoolbar");
        var btnInsert = toolbar.down('dbgridinsertbutton');
        var btnDelete = toolbar.down("dbgriddeletebutton");

        btnInsert.setDisabled(disabled);
        btnDelete.setDisabled(disabled);
    },

    beforeInsert: function () {
        var me = this;
        var getMaterialCandidateMediaUrl = webRoot + "/imms/media/media/" + this.materialId + "/getCandidateMaterialMedia.handler";
        this.filterStore.setSelectUrl(getMaterialCandidateMediaUrl);
        this.filterStore.getProxy().url = getMaterialCandidateMediaUrl;

        var filterOperation = Ext.create("app.ux.data.FilterOperation", {
            store: me.filterStore,
            columns: [
                { dataIndex: "mediaName", text: "名称", width: 120 },
                { dataIndex: "mediaDescription", text: "描述", width: 200 },
                { dataIndex: "mediaUrl", text: "URL", flex: 1 }
            ],
            callback: function (grid, selectedRecords) {
                me.createMaterialMedia(selectedRecords);
            }
        });
        setTimeout(function () {
            filterOperation.showFilterWindow();
            me.filterStore.load();
        });

        return false;
    },

    createMaterialMedia: function (records) {
        var me = this;
        var materialMedia = {
            materialId: me.materialId,
            medias: []
        };
        for (var i = 0; i < records.length; i++) {
            materialMedia.push(recors[i].get("mediaId"))
        }

        var url = jsRoot + "/imms/material/material/addMedias.handler";
        app.ux.Utils.ajaxRequest({
            url: url,
            method: 'POST',
            jsonData: materialMedia,
            successCallback: function () {
                me.store.load(function () {
                    Ext.toast({
                        html: '数据已保存',
                        title: '系统提示',
                        width: 200,
                        align: 't'
                    });
                });
            }
        })
    },
    beforeEdit: function () {
        //物料多媒体不可以修改，只可以新增、删除
        return false;
    }
});