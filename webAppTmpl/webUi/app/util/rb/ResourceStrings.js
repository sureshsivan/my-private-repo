/**
*	JS Class used to hold Resource Bundle key value pairs
*/
Ext.define('webUi.util.rb.ResourceStrings', {
	singleton : true,
	
	constructor : function(){
		var lang = webUi.util.AppSingleton.currentLocale;
		// get prop values from lang var
	},
	getStr : function(key, args){
		var val = '';
		if((args != null) && (args.length > 0)){
			for(var idx = 0; idx <= args.length; args++ ){
				val = val.replace(new RegExp("\\{" + idx + "\\}", "gi" ), arguments[idx] );
			}	
		}
	}
	
});