/**
 * Start Page Widget for Application
 */
Ext.define('webUi.view.HhidStart',{
	extend: 'Ext.container.Container',
	header: true,
	border: 2,
	style: {
	    borderColor: 'red',
	    borderStyle: 'solid'
	},
	layout: {
		type: 'hbox',
		align: 'middle',
		pach: 'center'
	},
	items:[
	    {
	    	xtype: 'textfield',
	    	name: 'summa'
	    }, 
	    {
	    	xtype: 'textfield',
	    	name: 'summas'
	    }
	]
});