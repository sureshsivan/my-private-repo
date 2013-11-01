/**
 * This is the rootpanel for the whole application
 */
Ext.define('webUi.view.Rootpanel', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.layout.container.Border',
        'webUi.view.common.Header',
        'webUi.view.common.CenterPanel',
        'webUi.view.common.Footer'
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
	        xtype: 'd-center-panel',
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
