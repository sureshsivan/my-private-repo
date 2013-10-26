/**
 * Singletons used throughout the application
 */
Ext.define('webUi.util.AppSingleton', {
	singleton : true,
	currentBundle : '',
	lang : 'en',
	constructor : function(){
		this.lang = (navigator.language || navigator.browserLanguage || navigator.userLanguage || this.lang)
        // window.navigator.userLanguage || window.navigator.language;
	}
	startAppLaunch: function (){
		console.log('#########');
		var vp = new webUi.view.Viewport();
		var rp = new webUi.view.Rootpanel();
		vp.add(rp);
		console.log('@@@@@@@@@');
	}

});