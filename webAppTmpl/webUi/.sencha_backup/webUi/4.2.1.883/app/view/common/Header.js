/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.Header', {
    extend: 'Ext.container.Container',
	requires: [
		'webUi.view.common.GuestBar',
		'webUi.view.common.InfoBar'
	],
    xtype: 'd-header',
    id: 'headerBar',
	layout: {
	    type: 'vbox'
	},
	items: [
	    {
	    	xtype: 'd-guest-bar',
	    	flex: 2.7
	    },
	    {
	    	xtype: 'd-infobar',
	    	flex: 1.3
	    }
	]
});