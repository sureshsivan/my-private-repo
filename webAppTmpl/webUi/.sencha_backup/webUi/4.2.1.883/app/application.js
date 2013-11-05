Ext.define('webUi.Application', {
    name: 'webUi',
    appFolder: 'app',
    extend: 'Ext.app.Application',
    requires: [
            'webUi.util.AppSingleton',
       		'Ext.window.MessageBox',
    		'Ext.util.HashMap',
    		'webUi.util.rb.ResourceBundle',
    ],
    views: [
            
    ],

    controllers: [
                  'Main'
    ],

    stores: [
         
    ]
});
