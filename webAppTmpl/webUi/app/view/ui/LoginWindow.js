/**
 * Login Window Widget
 * 
 */
Ext.define('webUi.view.ui.LoginWindow', {
	extend : 'Ext.form.Panel',
	xtype : 'd-login-form',
	title : 'Login',
	url	: webUi.util.AppSingleton.loginUrl, 
	frame : true,
	width : 400,
	height: '20%',
	minHeight: 180,
	bodyPadding : 10,
	defaultType : 'textfield',
	items : [{
		allowBlank : false,
		blankText: 'This field is required man..',
		fieldLabel : 'User ID',
		name : 'userId',
		emptyText : 'Type Email ID',
		width: 300
				
    },
    {
		allowBlank : false,
		blankText: 'This field is required man..',
		fieldLabel : 'Password',
		name : 'password',
		emptyText : 'Type Password',
		inputType : 'password',
		width: 300
	}],

	buttons : [{
	   	text : 'Login',
	   	disabled: true,
	   	formBind: true,
	   	handler: function(){
	   		var form = this.up('form').getForm();
            if (form.isValid()) {
                form.submit({
                    success: function(form, action) {
                       Ext.Msg.alert('Success', action);
                       
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
             }
		}
	}],
	
	onRender: function(){
		this.callParent(arguments);
	}
});