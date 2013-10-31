/**
 * This is the Contact Widget placed in Footer
 */
Ext.define('webUi.view.common.FooterContact', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-footer-contact',
//    bodyPadding : '10',
    border: false,
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items: [
        {
        	//html: '<b>Any Questions?</b>',
        	html: webUi.util.AppSingleton.getMsg('app.footer.anyQuestions'),
        	border: false,
        	padding: 5
        }, {
        	//html:'mail to <a href="mailto:v8@v8-delta.com">v8@v8-delta.com</a> Or Call XXX-XXXX-XXXX',
        	html:'mail to <a href="' + webUi.util.AppSingleton.getMsg('app.footer.contact.mail') + '">v8@v8-delta.com</a> Or Call '+ webUi.util.AppSingleton.getMsg('app.footer.contact.phone'),
        	border: false
        }
    ],
    initComponent: function(){
    	console.log('InitComponent');
    	this.callParent(arguments);
    }
});