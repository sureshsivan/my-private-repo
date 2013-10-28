Ext.define('webUi.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function(){
    	this.application.addListener({
    		'appStart': this.onAppStart,
    		'loadResources' : this.onLoadResources,
    		'resourcesLoaded': this.onResourceLoaded,
    		'resourcesLoadError': this.onResourceLoadError,
    		'loadAppParams': this.onLoadAppParams,
    		'appParamsLoaded': this.onAppParamsLoaded,
    	});
	},
	
	onAppStart: function(){
		var me = this;
		me.fireEvent('loadResources');
		me.fireEvent('loadAppParams');
	},
	
	onLoadResources: function(){
		console.log('Load Resources event handled');
		var bundle = Ext.create('webUi.util.rb.ResourceBundle'),
			me = this;
		bundle.onLoadComplete(function(){
			webUi.util.AppSingleton.bundle = bundle.rsrc;
			me.fireEvent('resourcesLoaded');
		});
	},

	onResourceLoaded: function(){
		var vp = new webUi.view.Viewport(),
	    rp = new webUi.view.Rootpanel();
		vp.add(rp);
		webUi.util.AppSingleton.handleError(webUi.util.AppSingleton.getMsg('two.three.custom', ['a', 'BB', 'XXX']));
	},
	
	onResourceLoadError: function(){
		
	},
	
	onLoadAppParams: function(){
		console.log('Load App Params event handled');
	},	

	onAppParamsLoaded: function(){
		console.log('App Param Loaded event handled');
	},


		
});
