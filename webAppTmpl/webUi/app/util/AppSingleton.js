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
	},
	bundle: null,
	uiRsrcUrl: '/web-1.0/mock/resources/messages',
	appParamUrl: '/web-1.0/mock/resources'
});