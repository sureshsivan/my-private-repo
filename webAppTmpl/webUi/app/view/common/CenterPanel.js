/**
 *	Widget for the center Panel in border layout 
 */
Ext.define('webUi.view.common.CenterPanel',{
	extend: 'Ext.panel.Panel',
	id: 'centerPanel',
	xtype: 'd-center-panel',
	bodyStyle: {
	    backgroundColor: '#e6e6e6'
	},
	clearItems: function(){
		console.log('[CenterPanel] Clearing Items');
	}
});