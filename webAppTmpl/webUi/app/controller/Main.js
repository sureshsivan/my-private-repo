Ext.define('webUi.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function(){
    	this.application.addListener({
    		'appStart': this.onAppStart,
    		'resourceLoaded': this.onResourceLoaded
    	});
	},
	
	onAppStart: function(){
		console.log('App Start event handled');
		console.log('Firing Resource Loaded event');
		webUi.getApplication().fireEvent('resourceLoaded');
	},
	
	onResourceLoaded: function(){
		console.log('Resource Loaded event handled');
		var vp = new webUi.view.Viewport(),
	    rp = new webUi.view.Rootpanel();
		vp.add(rp);
	},
	
	onMainWindowRendered: function(){
		console.log('Main Window Rendered');
	},
	onMainWindowTabRendered: function(){
		console.log('Main Window TAB Rendered');
	},
	onMainWindowClicked: function(){
		console.log('Main Window Clicked');
	},
	onMainWindowTabClicked: function(){
		console.log('Main Window Clicked');
	},
	onPanelCollapse: function(){
		console.log('Panel Collapsed');
	},
	onPanelExpand: function(){
		console.log('Panel Expanded');
	}
});
