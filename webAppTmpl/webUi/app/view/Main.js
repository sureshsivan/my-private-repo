Ext.define('webUi.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border'
    ],
    xtype: 'app-main',

    layout: {
        type: 'border',
        padding: 2
    },

    items: [
	    {
	        region: 'north',
	        xtype: 'panel',
	        header : false,
	        height: '10%',
	        border: false
	    },
	    {
	        region: 'west',
	        xtype: 'panel',
	        title: 'Main Menu',
	        width: '17%',
	        border: true,
	        collapsible: true,
	        //margins: '0 2 0 2',
	        split:true
	    },
	    {
	        region: 'center',
	        xtype: 'tabpanel',
	        border: true,
	        //plain: true,
	        items:[
		        {
		            title: 'Center Tab 1',
		            border:false
		        },
		        {
		            title: 'Center Tab 2'
		        },
		        {
		            title: 'Center Tab 3'
		        },
		        {
		            title: 'Center Tab 4'
		        },
		        {
		            title: 'Center Tab 5'
		        }
	        ]
	    },
	    {
	        region: 'east',
	        xtype: 'panel',
	        title: 'Work Area',
	        width: '13%',
	        border: true,
	        margins: '0 2 0 2'
	    },
	    {
	        region: 'south',
	        xtype: 'panel',
	        header : false,
	        height: '5%',
	        border: false
	    }
    ]
});