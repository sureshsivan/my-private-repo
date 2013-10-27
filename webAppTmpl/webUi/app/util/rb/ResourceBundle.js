/**
*	courtesy : https://github.com/elmasse/Ext.i18n.Bundle-touch/blob/master/i18n/Bundle.js
**/
Ext.define('webUi.util.rb.ResourceBundle', {
        extend: 'Ext.data.Store',
        requires: [
                   'webUi.util.rb.model.KeyValPair',
                   'webUi.util.rb.reader.Property'
        ],
        constructor: function(){
        	var me = this;
        	Ext.Ajax.request({
        	    url: webUi.util.AppSingleton.uiRsrcUrl,
        	    success: function(response){
        	    	console.log('Ajax Success');
        	    	console.log(response);
//        	    	me.fireEvent('responseText', response.responseText);
        	    	me.processResources(response.responseText);
        	    },
        	    failure: function(response){
        	    	console.log('Ajax Failure');
        	    	console.log(response);
        	    }
        	});
//        	me.addEvents('resourceLoaded', 'resourceProcessed');
//        	me.on('resourceLoaded', this.processResources, this);
        },
        processResources: function(data){
        	this.rsrc = new Ext.util.HashMap();
        	console.log('inside process resources');
        	console.log(data);
        	var records = [], record, kv,
            f = this.readLines(data),
            l = f.length;
		    for(var i = 0; i < l; i++){
	            var kl = f[i].search(/[\s:=]/);
	            this.rsrc.add(this.clearValueExtraChars(f[i].substring(kl+1)), 
	            			  this.clearKeyExtraChars(f[i].substring(0, kl)));
		    }
		    console.log(this.rsrc);
        },
        
        clearKeyExtraChars: function(s){
            return (s ? s.replace(/[:=]/gi, "") : "");
	    },
	    
	    clearValueExtraChars: function(s){
	            return (s ? s.replace(/\\\s*\n/gi, "") : "");
	    },
	    readLines: function(data){
	            var file = data.responseText;
	            return (file ? file.match(/.*(.*\\\s*\n)+.*|^((?!^\s*[#!]).).*$/gim) : []);
	    },
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        onBundleLoad: function(store, record, success, op) {
        	console.log(123);
        	if(success){
        		this.fireEvent('loaded');
	        } else{
	        	this.fireEvent('loadError');
	        }
        },
        onBundleLoadException: function(){
        	console.dir(arguments);
        	this.fireEvent('loadError');
        },
        onReady: function(fn){
            this.readyFn = fn;
            this.on('loaded', this.readyFn, this);
        },
        onError: function(fn){
            this.readyFn = fn;
            this.on('loadError', this.readyFn, this);
        },
        getMsg: function(key){
            return this.getById(key)? Ext.util.Format.htmlDecode(this.getById(key).get('val')) : key + '.undefined';
        },
        onProxyLoad: function(op){
        	console.log(arguments);
            if(op.getRecords()){
            		console.log(222);
                    this.callParent(arguments);
            }
        },
        loadParent: function(){
            this.getProxy().setUrl(webUi.util.AppSingleton.uiRsrcUrl);
            this.load();                        
    },
});