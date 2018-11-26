Ext.define('app.model.admin.SystemProgramModel', {
    extend: 'Ext.data.TreeModel',
    requires: ["app.ux.ZhxhDate","app.model.EmptyGenerator"],
    identifier:'empty',
    fields: [
    	  {name:"programId",type:"string",unique:true},
          {name:"programName",type:"string"},
          {name:"url",type:"string"},
          {name:"showOrder",type:"string"},
          {name:"parameters",type:"string"},
          {name:"status",type:"string"},
          {name:"glyph",type:"string"},
          {name:"parent",type:"string"},
    ],
    idProperty: 'programId'
});