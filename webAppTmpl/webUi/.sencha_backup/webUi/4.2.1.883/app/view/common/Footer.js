/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.Footer', {
    extend: 'Ext.container.Container',
    requires: [
		'webUi.view.common.Copyright',
		'webUi.view.common.FooterContact',
		'webUi.view.common.FooterLogo'
    ],
    xtype: 'd-footer',
	style: {
	    backgroundColor: '#969897'
	},
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
