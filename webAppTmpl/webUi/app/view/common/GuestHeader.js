/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.GuestHeader', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-guest-header',
    minHeight: 120,
	layout: {
	    type: 'vbox'
	},
	items: [
	    {
	    	xtype: 'd-footer',
	    	flex: 3
	    },
	    {
	    	xtype: 'd-info-bar',
	    	flex: 1
	    }
	]
});