/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.GuestHeader', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-guest-header',
	layout: {
	    type: 'vbox'
	},
	items: [
	    {
	    	html: '1'
	    }, 
	    {
	    	xtype: 'd-info-bar'
	    }
	]
});