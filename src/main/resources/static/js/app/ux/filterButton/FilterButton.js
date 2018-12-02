Ext.define("app.ux.filterButton.FilterButton", {
    extend: "Ext.button.Button",
    alias: "widget.filterButton",

    requires:["app.ux.data.FilterOperation"],
    mixins:["app.ux.data.FilterOperation"],    
    
    glyph: 0xf002,
    tooltip: '查找',
    
    handler: function () {
        this.showFilterWindow();
    }    
});