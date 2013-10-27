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
		var bundle = Ext.create('webUi.util.rb.ResourceBundle');
	},
		
//		bundle.onReady(function(){
//			console.log('%%%%%%%%%%%%%');
//			console.log(bundle.getMsg('one'));
//			console.log(bundle.getById('one'));
//			console.log(bundle.getAt(0));
//		});
////		bundle.onError(function(){
////			console.log('Error');
////		});
//	},
//	
	onResourceLoaded: function(){
		console.log('Resource Loaded event handled');
		var vp = new webUi.view.Viewport(),
	    rp = new webUi.view.Rootpanel();
		vp.add(rp);
	}
		
		
});
