/**
 * This is the rootpanel for the whole application
 */
Ext.define('webUi.view.Rootpanel', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.layout.container.Border'
    ],
    xtype: 'd-rootpanel',
    border: false,
    layout: {
        type: 'border',
        padding: 0
    },

    items: [
	    {
	        region: 'north',
	        xtype: 'd-header',
	        header : false,
	        height: 150,
	        border: false
	    },
	    {
	        region: 'center',
	        xtype: 'container',
			style: {
			    backgroundColor: '#e6e6e6'
			}
	    },
	    {
	        region: 'south',
	        xtype: 'd-footer',
	        header : false,
	        height: 50,
	        border: false
	    }
    ]
});
