/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.Footer', {
    extend: 'Ext.panel.Panel',
    requires:[
        'Ext.layout.container.Border'
    ],
    xtype: 'd-footer',
    margin: 2,
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
