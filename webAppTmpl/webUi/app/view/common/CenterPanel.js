/**
 *	Widget for the center Panel in border layout 
 */
Ext.define('webUi.view.common.CenterPanel',{
	extend: 'Ext.panel.Panel',
	requires: [
	    'webUi.view.ui.LoginWindow'
	],
	id: 'centerPanel',
	xtype: 'd-center-panel',
	clearItems: function(){
		console.log('[CenterPanel] Clearing Items');
	}
});