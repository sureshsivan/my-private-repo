/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.Footer', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-footer',
    margin: 0,
    minHeight: 50,
    layout: {
        type: 'hbox',
        align: 'middle'
    },
    items: [
        {
        	xtype: 'd-copyright',
        	flex: 1
        },
        {
        	xtype: 'd-footer-contact',
        	flex: 1
        },
        {
        	xtype: 'd-footer-logo',
        	flex: 1
        }
    ]
});
