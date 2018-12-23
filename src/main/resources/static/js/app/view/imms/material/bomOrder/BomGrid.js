Ext.define("app.view.imms.material.bomOrder.BomGrid", {
    extend: "app.ux.dbgrid.TreeGrid",
    xtype: "app_view_imms_material_bomOrder_BomGrid",
    uses: ['app.view.imms.material.bomOrder.BomDetailForm',
        "app.model.imms.material.BomModel",
        "app.store.imms.material.BomStore",
        "app.ux.dbgrid.DbGridInsertButton"],

    rootVisible: false,
    columns: [
        {
            text: '组件编号',
            dataIndex: 'componentMaterialNo',
            width: 250
        },
        {
            text: '组件名称',
            dataIndex: 'componentMaterialName',
            width: 300,
        },
        {
            text: '组件用量',
            dataIndex: 'componentQty',
            width: 100,
            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return record.get("componentQty") + "/" + record.get("componentMaterialUomName") + "(" + record.get("componentMaterialUomNo") + ")";
            }
        },
        {
            text: '组件类型',
            dataIndex: 'componentTypeName',
            width: 80,
            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                return value + "(" + record.get("componentTypeNo") + ")";
            }
        }, {
            text: '是否主面料',
            dataIndex: 'ifMainFabric',
            width: 100,
            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                if (value == true) {
                    return "是";
                }
                return "否";
            }
        }, {
            text: '数据来源',
            dataIndex: 'bomDataSource',
            width: 100,
            renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                if (value == 'I') {
                    return "内建";
                }
                return "导入";
            }
        }
    ],

    constructor: function (config) {
        var bomStore = Ext.create({ xtype: "app_store_imms_material_BomStore", autoLoad: false });
        bomStore.getProxy().url = webRoot + "/imms/material/bom/getAll.handler";

        var configBase = {
            store: bomStore,
            detailFormClass: 'app_view_imms_material_bomOrder_BomDetailForm',
            detailWindowTitle: 'BOM',
        }
        Ext.applyIf(config, configBase);

        this.callParent(arguments);
    },

    beforeComponentInit:function(e){
        if(e.sender==null||e.sender.$className!='app.ux.dbgrid.DbGridToolbar'){
            return;
        }
        
        e.config.items.push({
            xtype: 'dbgridinsertbutton',
            privilege: "INSERT",
            disabled: true,
            btnName:"btnInsertBrother",
            dbGrid:this       
        })
    },

    setToolbarDisabled:function(disabled){
        var toolbar = this.down("dbgridtoolbar");
        var buttons = toolbar.query('dbgridbutton');
        debugger;
        
        for(var i=0;i<buttons.length;i++){
            buttons[i].setDisabled(disabled);
        }
    },

    initComponent: function () {
        this.callParent(arguments);

        var toolbar = this.down("dbgridtoolbar");
        var btnInsert = toolbar.down('[btnName="btnInsert"]');
        btnInsert.text="新增下级";

        var btnInsertBrother =toolbar.down('[btnName="btnInsertBrother"]');
        btnInsertBrother.text="新增同级";       
    },

});