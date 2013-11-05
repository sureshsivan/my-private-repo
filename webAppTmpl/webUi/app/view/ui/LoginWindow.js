/**
 * Login Window Widget
 * 
 */
Ext.define('webUi.view.ui.LoginWindow', {
	extend : 'Ext.form.Panel',
	xtype : 'd-login-form',
	title : 'Login',
	frame : true,
	width : 400,
	height: '20%',
	minHeight: 180,
	bodyPadding : 10,
	defaultType : 'textfield',
	items : [
	    {
			allowBlank : false,
			fieldLabel : 'User ID',
			name : 'userId',
			emptyText : 'Type Email ID',
			width: 300
				
	    },
	    {
			allowBlank : false,
			fieldLabel : 'Password',
			name : 'password',
			emptyText : 'Type Password',
			inputType : 'password',
			width: 300
	    }
	],

	buttons : [
	    {
	    	text : 'Register'
	    }, 
	    {
	    	text : 'Login'
	    }
	],
	
	onRender: function(){
		this.callParent(arguments);
	}
});