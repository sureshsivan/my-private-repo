/**
 * Login Window Widget
 * 
 */
Ext.define('webUi.view.ui.LoginWindow', {
	extend : 'Ext.form.Panel',
	xtype : 'd-login-form',
	title : 'Login',
	frame : true,
	width : '30%',
	height: '20%',
	bodyPadding : 10,
	defaultType : 'textfield',
	
	items : [
	    {
			allowBlank : false,
			fieldLabel : 'User ID',
			name : 'user',
			emptyText : 'user id'
	    },
	    {
			allowBlank : false,
			fieldLabel : 'Password',
			name : 'pass',
			emptyText : 'password',
			inputType : 'password'
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