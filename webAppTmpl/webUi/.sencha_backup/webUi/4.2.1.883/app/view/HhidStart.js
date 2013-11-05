/**
 * Start Page Widget for Application
 */
Ext.define('webUi.view.HhidStart',{
	extend: 'Ext.container.Container',
	header: true,
	border: '2 0',
	style: {
	    borderColor: 'red',
	    borderStyle: 'solid'
	},
	layout: {
		type: 'ux.center'
//		align: 'left',
//		pack: 'middle'
	},
	items:[
	       {
	    	xtype: 'panel',
	    	width: '70%',
	    	title: false,
	    	border: false,
	    	widthRatio: 0.75,
		   	layout: {
		   		type: 'vbox',
		   		align: 'left',
		   		pack: 'start',
		   		padding: '50'
		   	},
	    	items:[
			    {
			    	xtype: 'box',
			    	cls: 'headerTxt',
			    	html: webUi.util.AppSingleton.getMsg('app.welcomeMsg'),
			    	
			    }, 
			    {
			    	xtype: 'box',
			    	cls: 'infoTxt',
			    	html: webUi.util.AppSingleton.getMsg('app.welcome.site.info')
			    }, 
			    {
			    	xtype: 'box',
			    	cls: 'infoTxt bold',
			    	html: webUi.util.AppSingleton.getMsg('app.welcome.start.info')
			    }, 
			    {
			    	xtype: 'form',
			    	url: 'initSubmission.do',
			    	width: '100%',
			    	layout: {
			    		type: 'hbox',
			    		align: 'middle',
			    		pack: 'left'	
			    	},
			    	border: false,
			    	items:[
			    	    {
			    	    	xtype: 'textfield',
			    	    	name: 'login',
			    	    	allowBlank: false,
			    	    	vtype: 'email',
			    	    	vTypetext: 'Cannot be blank',
			    	    	emptyText: 'Enter HHID or email ID',
			    	    	width: 350,
			    	    	height: 30
			    	    }, 
			    	    {
			    	    	xtype: 'button',
			    	    	text: 'Go',
			    	    	padding: '0 10',
			    	    	height: 30,
			    	    	margin: 20,
			    	    	width: 100,
			    	    	handler: function(){
			    	    		var form = this.up('form').getForm();
			    	    		if(form.isValid()){
			    	    			form.submit({
			    	                    success: function(form, action) {
			    	                       Ext.Msg.alert('Success', action.result.msg);
			    	                    },
			    	                    failure: function(form, action) {
			    	                        Ext.Msg.alert('Failed', action.result.msg);
			    	                    }
			    	                });
			    	    		}
			    	    	}
			    	    }
			    	]
			    	
			    }
	    	]
	    }
	]
});