/**
*	courtesy : https://github.com/elmasse/Ext.i18n.Bundle-touch/blob/master/i18n/Bundle.js
**/
Ext.define('webUi.util.rb.ResourceBundle', {
        extend: 'Ext.data.Store',
        requires: [
                   'webUi.util.rb.model.KeyValPair'
        ],
        constructor: function(config){
            config = config || {};
            var me = this;
            Ext.applyIf(config, {
                    autoLoad: true,
                    model: 'webUi.util.rb.model.KeyValPair',
                    proxy:{
                            type: 'ajax',
                            url: webUi.util.AppSingleton.uiRsrcUrl,
                            noCache: true,
                            reader: {
                                    type: 'json',
                                    rootProperty: 'bundle'
                            },
                            //avoid sending limit, start & group params to server
                            getParams: Ext.emptyFn
                    },
                    listeners:{
                            'load': this.onBundleLoad,
                            scope: this
                    }
            });

            me.callParent([config]);
            me.getProxy().on('exception', this.onBundleLoadException, this, {single: true});
        },
        
        onBundleLoad: function(store, record, success, op) {
        	if(success){
        		this.fireEvent('loaded');
	        } else{
	        	this.fireEvent('loadError');
	        }
        },
        onBundleLoadException: function(){
        	console.dir(arguments);
        },
        onReady: function(fn){
            this.readyFn = fn;
            this.on('loaded', this.readyFn, this);
        },
        getMsg: function(key){
            return this.getById(key)? Ext.util.Format.htmlDecode(this.getById(key).get('val')) : key + '.undefined';
        }
});