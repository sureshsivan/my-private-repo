/**
 * Start Page Widget for Application
 */
Ext.define('webUi.view.HhidStart',{
	extend: 'Ext.container.Container',
	header: true,
	border: '2 0',
	padding: 10,
	style: {
	    borderColor: 'red',
	    borderStyle: 'solid'
	},
	layout: {
		type: 'vbox',
		align: 'left',
		pack: 'center',
		padding: '0 0 0 50'
	},
	items:[
	    {
	    	html: webUi.util.AppSingleton.getMsg('app.welcomeMsg')
	    }, 
	    {
	    	html: webUi.util.AppSingleton.getMsg('app.welcome.site.info')
	    }, 
	    {
	    	html: webUi.util.AppSingleton.getMsg('app.welcome.start.info')
	    }, 
	    {
	    	xtype: 'container',
	    	width: '100%',
	    	layout: {
	    		type: 'hbox',
	    		align: 'middle',
	    		pack: 'left'	
	    	},
	    	items:[
	    	    {
	    	    	xtype: 'textfield',
	    	    	name: 'summa',
	    	    	emptyText: 'Enter HHID or email ID',
	    	    	width: '40%',
	    	    	height: 30
	    	    }, 
	    	    {
	    	    	xtype: 'button',
	    	    	name: 'summas',
	    	    	text: 'Go',
	    	    	padding: '0 10',
	    	    	height: 30,
	    	    	margin: 20
	    	    }
	    	]
	    	
	    }
	]
});