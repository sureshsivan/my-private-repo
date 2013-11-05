/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.GuestBar', {
    extend: 'Ext.container.Container',
    xtype: 'd-guest-bar',
	layout: {
	    type: 'vbox'
	},
	width: '100%',
	border: false,
	style: {
	    backgroundColor: '#189ee7'
	},
	items: []
});