Ext.define('webUi.view.Viewport', {
    extend: 'Ext.container.Viewport',
	requires: [
		'Ext.layout.container.Fit',
		'webUi.view.common.InfoBar',
		'webUi.view.Rootpanel'
	],
    layout: {
        type: 'fit'
    },

    items: [
            //	kept it as blank as adding components only after resource files are loaded 
    ],
    initComponent: function(){
    	this.callParent(arguments);
    }
});
