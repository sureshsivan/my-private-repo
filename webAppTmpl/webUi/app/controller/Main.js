Ext.define('webUi.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function(){
		this.control({
			'viewport > app-main' : {
				render : this.onMainWindowRendered
			}
		});
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
