Ext.define('webUi.controller.Main', {
    extend: 'Ext.app.Controller',
	requires:[
	    'webUi.view.ui.LoginWindow'
	],
    init: function(){
    	this.application.addListener({
    		'appStart': this.onAppStart,
    		'loadResources' : this.onLoadResources,
    		'resourcesLoaded': this.onResourceLoaded,
    		'resourcesLoadError': this.onResourceLoadError,
    		'loadAppParams': this.onLoadAppParams,
    		'appParamsLoaded': this.onAppParamsLoaded,
    		'appParamsLoadError': this.onAppParamsLoadError,
    		'kickOffui': this.onKickOffUi,
    		'showStartPage': this.onShowStartPage
    	});
	},
	
	onAppStart: function(){
		var me = this;
		me.fireEvent('loadResources');
		webUi.util.AppSingleton.showMask('loadResources', webUi.util.AppSingleton.getAppConfigMsg('rsrcBndlLoadMsg'));
		me.fireEvent('loadAppParams');
		webUi.util.AppSingleton.showMask('loadAppParams', webUi.util.AppSingleton.getAppConfigMsg('appConfigLoadMsg'));
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
		webUi.util.AppSingleton.removeMask('loadResources');
		if(webUi.util.AppSingleton.checkAppConfigLoaded() === true){
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
		webUi.util.AppSingleton.removeMask('loadAppParams');
		if(webUi.util.AppSingleton.checkAppConfigLoaded() === true){
			this.fireEvent('kickOffui');
		}
	},
	
	onAppParamsLoadError: function(){
		webUi.util.AppSingleton.handleError('Error In Application Parameters Load');
	},
	
	onKickOffUi: function(){
		console.log('UI kick Off Start');
		var vp = Ext.create('webUi.view.Viewport'),
			rp = Ext.create('webUi.view.Rootpanel');
		vp.add(rp);
		this.fireEvent('showStartPage');
	},
	onShowStartPage: function(){
		Ext.getCmp('centerPanel').clearItems();
		Ext.getCmp('infoBar').clearItems();
//		var login = Ext.create('webUi.view.ui.LoginWindow');
//		login.show();
//		var cc = Ext.create('webUi.view.HhidStart');
		Ext.getCmp('centerPanel').layout = 'ux.center';
		Ext.getCmp('centerPanel').add(Ext.create('webUi.view.ui.LoginWindow'));
	}
		
});
