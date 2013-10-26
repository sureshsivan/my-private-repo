Ext.define('webUi.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function(){
    	this.application.addListener({
    		'appStart': this.onAppStart,
    		'appParamsLoaded': this.onResourceLoaded,
    		'resourcesLoaded': this.onResourceLoaded
    	});
	},
	
	onAppStart: function(){
		var bundle = Ext.create('webUi.util.rb.Bundle',{
								            bundle: 'Application',
								            lang: 'es-ES',
								            path: webUi.util.AppSingleton.uiRsrcUrl,   //'/web-1.0/mock/resources',
								            noCache: false
										}); 
		bundle.onReady(function(){
			console.log('Bundle is Loaded');
			webUi.getApplication().fireEvent('resourceLoaded');
		});
	},
	
	onResourceLoaded: function(){
		console.log('Resource Loaded event handled');
		var vp = new webUi.view.Viewport(),
	    rp = new webUi.view.Rootpanel();
		vp.add(rp);
	},
});
