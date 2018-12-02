Ext.define('app.view.imms.code.defectCode.DefectCodeDetailForm', {
    extend: 'Ext.form.FormPanel',
    xtype: 'app_view_imms_code_defectCode_DefectCodeDetailForm',
    bodyPadding: 5,
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    width: 400,
    items: [
        {
            vid: 'parentDefectCode',
            xtype: "textfield",
            readOnly: true,
            fieldLabel: "上级编号"
        },{
            vid:"parentName",
            xtype:"textfield",
            readOnly:true,            
            fieldLabel:"上级名称"
        },{
            name: "defectCodeId",
            xtype: "hidden",
        },{
            name: "parentDefectCodeId",
            xtype: "hidden",
        },
        {
            name: 'defectCodeNo',
            fieldLabel: '缺陷编号',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 10,
            enforceMaxLength: true,
        }, {
            name: 'defectCodeName',
            fieldLabel: '缺陷名称',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 30,
            enforceMaxLength: true,
        },
        {
            name: 'defectCodeDescription',
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
            var txtParentCode = this.down('[vid="parentDefectCode"]');
            var parentName,parentCode,parentDefectCodeId;
	
            if (config.dataMode == app.ux.data.DataMode.INSERT) {
                parentDefectCodeId = currentRecord.get("defectCodeId");                
                config.record.set("parentDefecCodetId", parentDefectCodeId); 
                this.down('[name="parentDefectCodeId"]').setValue(parentDefectCodeId);

                parentName = currentRecord.get("defectCodeName");
                parentCode = currentRecord.get("defectCodeNo");
	        }else{
	            var index = grid.store.find("defectCodeId",currentRecord.get("parentDefectCodeId"));
                var parent = grid.store.getAt(index);                
                
                parentName = parent.get("defectCodeName");
                parentCode = parent.get("defectCodeNo");
            }
            
            txtParentName.setValue (parentName);
            txtParentCode.setValue (parentCode);
        }
    }
});