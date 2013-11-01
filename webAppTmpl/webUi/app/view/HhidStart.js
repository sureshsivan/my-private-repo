/**
 * Start Page Widget for Application
 */
Ext.define('webUi.view.HhidStart',{
	extend: 'Ext.container.Container',
	header: true,
	border: 2,
	padding: 10,
	style: {
	    borderColor: 'red',
	    borderStyle: 'solid'
	},
	layout: {
		type: 'vbox',
		align: 'center',
		pack: 'center'
	},
	items:[
	    {
	    	html: 'Summa Text'
	    }, 
	    {
	    	xtype: 'container',
	    	width: '100%',
	    	layout: {
	    		type: 'hbox',
	    		align: 'middle',
	    		pack: 'center'
	    	},
	    	items:[
	    	    {
	    	    	xtype: 'textfield',
	    	    	name: 'summa',
	    	    	emptyText: 'Enter HHID or email ID',
	    	    	width: '40%',
	    	    	height: 30,
	    	    	margin: 20
	    	    }, 
	    	    {
	    	    	xtype: 'button',
	    	    	name: 'summas',
	    	    	height: 30,
	    	    	text: 'Go',
	    	    	padding: '0 10'
	    	    	
	    	    }
	    	]
	    	
	    }
	]
});