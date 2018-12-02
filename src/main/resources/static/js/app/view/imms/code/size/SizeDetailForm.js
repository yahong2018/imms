Ext.define('app.view.imms.code.size.SizeDetailForm', {
    extend: 'Ext.form.FormPanel',
    xtype: 'app_view_imms_code_size_SizeDetailForm',
    bodyPadding: 5,
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    width: 400,
    items: [
        {
            vid: 'parentCode',
            xtype: "textfield",
            readOnly: true,
            fieldLabel: "上级编号"
        },{
            vid:"parentName",
            xtype:"textfield",
            readOnly:true,            
            fieldLabel:"上级名称"
        },{
            name: "sizeId",
            xtype: "hidden",
        },{
            name: "parentSizeId",
            xtype: "hidden",
        },
        {
            name: 'sizeNo',
            fieldLabel: '尺码编号',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 10,
            enforceMaxLength: true,
        }, {
            name: 'sizeName',
            fieldLabel: '尺码名称',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 30,
            enforceMaxLength: true,
        },
        {
            name: 'sizeDescription',
            fieldLabel: '描述',
            xtype: "textarea",
            maxLength: 250,
            enforceMaxLength: true,
        }
    ],
    onRecordLoad: function (config) {        
        var grid = this.up("detailwindow").listGrid; //获取到Grid
        if(grid.getSelectedRecord() != null){      
        	var currentRecord = grid.getSelectedRecord();//获取到当前的记录
            var txtParentName = this.down('[vid="parentName"]');
            var txtParentCode = this.down('[vid="parentCode"]');
            	
            if (config.dataMode === app.ux.data.DataMode.INSERT) { //如果是新建
                var parentId = currentRecord.get("sizeId");
                config.record.set("parentSizeId", parentId);    
                this.down('[name="parentSizeId"]').setValue(parentId);

                txtParentName.setValue (currentRecord.get("sizeName"));
                txtParentCode.setValue (currentRecord.get("sizeNo"));
	        }else{
	            var index = grid.store.find("sizeId",currentRecord.get("parentSizeId"));
	            var parent = grid.store.getAt(index);
                txtParentName.setValue (parent.get("sizeName"));
                txtParentCode.setValue (parent.get("sizeNo"));
	        }
        }
    }
});