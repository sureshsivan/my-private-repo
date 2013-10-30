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
    		'appParamsLoadError': this.onAppParamsLoadError,
    		'kickOffui': this.onKickOffUi
    	});
	},
	
	onAppStart: function(){
		var me = this;
		me.fireEvent('loadResources');
		me.fireEvent('loadAppParams');
	},
	
	onLoadResources: function(){
		webUi.util.AppSingleton.isBundleLoaded = false;
		var bundle = Ext.create('webUi.util.rb.ResourceBundle', {
			url: webUi.util.AppSingleton.uiRsrcUrl
		}),
			me = this;
		bundle.onLoadComplete(function(){
			webUi.util.AppSingleton.bundle = bundle.rsrc;
			webUi.util.AppSingleton.isBundleLoaded = true;
			me.fireEvent('resourcesLoaded');
		});
	},

	onResourceLoaded: function(){
		console.log('^^^^^^^^^^^^onResourceLoaded^^^^^^^^^^');
		if(webUi.util.AppSingleton.checkAppConfigLoaded === true){
			this.fireEvent('kickOffui');
		}
	},
	
	onResourceLoadError: function(){
		webUi.util.AppSingleton.handleError('Error In Resource Load');
	},
	
	onLoadAppParams: function(){
		webUi.util.AppSingleton.isAppParamLoaded = false;
		var appParams = Ext.create('webUi.util.rb.ResourceBundle', {
			url: webUi.util.AppSingleton.appParamUrl
		}),
			me = this;
		appParams.onLoadComplete(function(){
			webUi.util.AppSingleton.appParam = appParams.rsrc;
			webUi.util.AppSingleton.isAppParamLoaded = true;
			me.fireEvent('appParamsLoaded');
		});
	},	

	onAppParamsLoaded: function(){
		console.log('^^^^^^^^^^^^onAppParamsLoaded^^^^^^^^^^');
		if(webUi.util.AppSingleton.checkAppConfigLoaded === true){
			this.fireEvent('kickOffui');
		}
	},
	
	onAppParamsLoadError: function(){
		webUi.util.AppSingleton.handleError('Error In Application Parameters Load');
	},
	
	onKickOffUi: function(){
		console.log('UI Kick Off>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');
//		var vp = new webUi.view.Viewport(),
//	    rp = new webUi.view.Rootpanel();
//		vp.add(rp);
	}
		
});
