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
        	html: '<b>Any Questions?</b>',
        	border: false,
        	padding: 5
        }, {
        	html:'mail to <a href="mailto:v8@v8-delta.com">v8@v8-delta.com</a> Or Call XXX-XXXX-XXXX',
        	border: false
        }
    ]
});