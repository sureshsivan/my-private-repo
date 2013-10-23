/**
 * This is the rootpanel for the whole application
 */
Ext.define('webUi.view.Rootpanel', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.layout.container.Border'
    ],
    xtype: 'd-rootpanel',

    layout: {
        type: 'border',
        padding: 2
    },

    items: [
	    {
	        region: 'north',
	        xtype: 'd-guest-header',
	        header : false,
	        height: '10%',
	        border: false
	    },
	    {
	        region: 'center',
	        xtype: 'panel',
//	        title: 'Body',
	        border: true,
	        bodyPadding : 15,
	        html: 'This is center panel'
	    },
	    {
	        region: 'south',
	        xtype: 'd-footer',
	        header : false,
	        height: '5%',
	        border: false
	    }
    ]
});
