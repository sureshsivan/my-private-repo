/**
 * Singletons used throughout the application
 */
Ext.define('webUi.util.AppSingleton', {
	singleton : true,
	currentBundle : '',
	lang : 'en',
	isBundleLoaded : false,
	uiRsrcUrl: '/web-1.0/appConfig/resources',
	appParamUrl: '/web-1.0/appConfig/params',
	bundle: null,
	appParam: null,
	
    msgKeyNotFound: 'Message not found for key:',
    msgBundleNotLoaded: 'Bundle Not loaded, Pls reload the application or Contact System ADMIN',
    msgAppParamNotLoaded: 'Application Parameters Not loaded, Pls reload the application or Contact System ADMIN',
    msgError: 'Error',

	constructor : function(){
		this.lang = (navigator.language || navigator.browserLanguage || navigator.userLanguage || this.lang)
        // window.navigator.userLanguage || window.navigator.language;
	},
    getMsg: function(key){
		if(this.bundle == null){
			return this.msgBundleNotLoaded;
		}
    	var msg = this.bundle.get(key);
    	if((msg != null) && (msg !== 'undefined') && 
    			(arguments.length > 0) && (Ext.isArray(arguments[1])) && (arguments[1].length > 0)){
    		var phCnt = arguments[1].length;
    		for(ph=0; ph<phCnt; ph++){
    			msg = msg.replace(new RegExp("\\{" + ph + "\\}", "gi" ), arguments[1][ph]);
    		}
    	}
    	return (((msg != null) && (msg != 'undefined')) ? msg : this.msgKeyNotFound + key);
    },
    getAppParam: function(key){
		if(this.appParam == null){
			return this.msgAppParamNotLoaded;
		}
    	var msg = this.appParam.get(key);
    	return (((msg != null) && (msg != 'undefined')) ? msg : this.msgKeyNotFound + key);
    },
    handleError: function(msg, logMsg){
    	Ext.Msg.alert(this.msgError, msg);
    	if(logMsg){
    		console.log(logMsg);
    	}
    }
    

});