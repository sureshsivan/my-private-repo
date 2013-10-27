Ext.define('webUi.util.rb.model.Property', {
    extend: 'Ext.data.Model',
    config: {
            idProperty: 'key',
            fields: ['key', 'val']
    },
    constructor: function(key, val){
    	this.key = key;
    	this.val = val;
    }
});