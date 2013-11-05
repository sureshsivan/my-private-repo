/**
*	courtesy : https://github.com/elmasse/Ext.i18n.Bundle-touch/blob/master/i18n/Bundle.js
**/
Ext.define('webUi.util.rb.ResourceBundle', {
        requires: [
                   'webUi.util.rb.model.KeyValPair',
                   'webUi.util.rb.reader.Property'
        ],
		mixins: {
		    observable: 'Ext.util.Observable'
		},
		config: {
			url: ''
		},
        constructor: function(config){
        	this.initConfig(config);
        	var me = this;
        	Ext.Ajax.request({
        		url: me.getUrl(),
        	    success: function(response){
        	    	me.processResources(response.responseText);
        	    },
        	    failure: function(response){
        	    	console.log(response);
        	    }
        	});
        	me.mixins.observable.constructor.call(me);
        	me.addEvents('loaded');
        },
        processResources: function(data){
        	this.rsrc = new Ext.util.HashMap();
        	var f = JSON.parse(data),
        		l = f.length;
		    for(var i = 0; i < l; i++){
	            var kl = f[i].search(/[\s:=]/);
	            this.rsrc.add(this.clearKeyExtraChars(f[i].substring(0, kl)), 
	            				this.clearValueExtraChars(f[i].substring(kl+1)));
		    }
		    this.fireEvent('loaded');
        },
        
        clearKeyExtraChars: function(s){
            return (s ? s.replace(/[:=]/gi, "") : "");
	    },
	    
	    clearValueExtraChars: function(s){
	            return (s ? s.replace(/\\\s*\n/gi, "") : "");
	    },
	    onLoadComplete: function(fn){
	    	this.successFn = fn;
	    	this.on('loaded', this.successFn, this);
	    }
        
});