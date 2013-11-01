/**
 * This is the Contact Widget placed in Footer
 */
Ext.define('webUi.view.common.FooterContact', {
    extend: 'Ext.container.Container',
    xtype: 'd-footer-contact',
    border: false,
    layout: {
        type: 'vbox',
        align: 'center'
    },
    items: [
        {
        	xtype: 'container',
        	html: webUi.util.AppSingleton.getMsg('app.footer.anyQuestions'),
        	border: false,
        	padding: 5
        }, {
        	xtype: 'container',
        	html:'mail to <a href="' + webUi.util.AppSingleton.getMsg('app.footer.contact.mail') + '">v8@v8-delta.com</a> Or Call '+ webUi.util.AppSingleton.getMsg('app.footer.contact.phone'),
        	border: false
        }
    ]
});