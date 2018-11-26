Ext.define("app.store.StoreOperation", {
    requires: ['app.ux.MapDataMeta'],

    urlMeta: null,
    getSelectUrl: function () {
        return this.getUrl("URL_SELECT");
    },
    setSelectUrl: function (url, isAbsolute) {
        this.setUrl("URL_SELECT", url, isAbsolute);
    },
    getUpdateUrl: function () {
        return this.getUrl("URL_UPDATE");
    },
    setUpdateUrl: function (url, isAbsolute) {
        this.setUrl("URL_UPDATE", url, isAbsolute)
    },
    getDeleteUrl: function () {
        return this.getUrl("URL_DELETE");
    },
    setDeleteUrl: function (url, isAbsolute) {
        this.setUrl("URL_DELETE", url, isAbsolute);
    },
    getInsertUrl: function () {
        return this.getUrl("URL_INSERT");
    },
    setInsertUrl: function (url, isAbsolute) {
        this.setUrl("URL_INSERT", url, isAbsolute);
    },
    getUrl: function (key) {
        return this.urlMeta.get(key);
    },
    setUrl: function (key, url, isAbsolute) {
        if (!isAbsolute) {
            url = webRoot + url;
        }
        this.urlMeta.put(key, url);
    },

    initUrlMeta: function () {
        this.urlMeta = Ext.create('app.ux.MapDataMeta');
        if (this.dao) {
            this.setSelectUrl(this.dao.selectUrl);
            this.setUpdateUrl(this.dao.updateUrl);
            this.setDeleteUrl(this.dao.deleteUrl);
            this.setInsertUrl(this.dao.insertUrl);
        }       
    }
});