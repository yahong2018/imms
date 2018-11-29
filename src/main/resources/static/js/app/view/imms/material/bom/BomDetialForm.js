Ext.define('app.view.imms.material.bom.BomDetailForm', {
    extend: 'Ext.form.FormPanel',
    xtype: 'app_view_imms_material_bom_BomDetailForm',
    bodyPadding: 5,
    layout: "anchor",
    defaults: {
        labelWidth: 90,
        anchor: "100%",
    },
    width: 400,
    items: [
       {
            name: "rowId",
            xtype: "hidden",
        },
        {
            name: 'uomNo',
            fieldLabel: '单位编号',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 10,
            enforceMaxLength: true,
        }, {
            name: 'uomName',
            fieldLabel: '单位名称',
            allowBlank: false,
            xtype: 'textfield',
            maxLength: 30,
            enforceMaxLength: true,
        },
        {
            name: 'description',
            fieldLabel: '单位描述',
            xtype: "textarea",
            maxLength: 250,
            enforceMaxLength: true,
        }
    ]
});