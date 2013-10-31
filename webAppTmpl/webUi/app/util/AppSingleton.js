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
	isBundleLoaded: false,
	appParam: null,
	isAppParamLoaded: false,
    defaultLanguage : 'en',
    messages : {
        'en' : {
		    'msgKeyNotFound': 'Message not found for key:',
		    'msgBundleNotLoaded': 'Bundle Not loaded, Pls reload the application or Contact System ADMIN',
		    'msgAppParamNotLoaded': 'Application Parameters Not loaded, Pls reload the application or Contact System ADMIN',
		    'msgError': 'Error'
		},
        'es' : {
		    'msgKeyNotFound': 'Message not found for key:_ES',
		    'msgBundleNotLoaded': 'Bundle Not loaded, Pls reload the application or Contact System ADMIN_ES',
		    'msgAppParamNotLoaded': 'Application Parameters Not loaded, Pls reload the application or Contact System ADMIN_ES',
		    'msgError': 'Error_ES'
        }
    },

	constructor : function(config){
        this.defaultLanguage = (navigator.language || navigator.browserLanguage || navigator.userLanguage || this.defaultLanguage).substring(0, 2);
	},
    getMsg: function(key){
    	console.log(key);
		if(this.bundle == null){
			this.handleError(this.getAppConfigErrMsg('msgBundleNotLoaded'));
			return '';
		}
    	var msg = this.bundle.get(key);
    	if((msg != null) && (msg !== 'undefined') && 
    			(arguments.length > 0) && (Ext.isArray(arguments[1])) && (arguments[1].length > 0)){
    		var phCnt = arguments[1].length;
    		for(ph=0; ph<phCnt; ph++){
    			msg = msg.replace(new RegExp("\\{" + ph + "\\}", "gi" ), arguments[1][ph]);
    		}
    	}
    	msg = (((msg != null) && (msg != 'undefined')) ? msg : this.getAppConfigErrMsg('msgKeyNotFound') + key);
    	console.log(msg);
    	return msg;
    },
    getAppParam: function(key){
    	console.log(key);
		if(this.appParam == null){
			this.handleError(this.getAppConfigErrMsg('msgAppParamNotLoaded'));
			return '';
		}
    	var msg = this.appParam.get(key);
    	msg = (((msg != null) && (msg != 'undefined')) ? msg : this.getAppConfigErrMsg('msgKeyNotFound') + key);
    	console.log(msg);
    	return msg;
    },
    handleError: function(msg, logMsg){
    	console.log(msg);
    	console.log(logMsg);
//    	Ext.Msg.alert(this.getAppConfigErrMsg('msgError'), msg);
//    	if(logMsg){
//    		console.log(logMsg);
//    	}
    },
    checkAppConfigLoaded: function(){
    	console.log('Checking for load...>>>>.');
    	return (this.isBundleLoaded && this.isAppParamLoaded);
    },
    getAppConfigErrMsg: function(key){
    	return this.messages[this.defaultLanguage][key];
    }
    

});