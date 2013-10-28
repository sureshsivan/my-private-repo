Ext.define('webUi.Application', {
    name: 'webUi',
    appFolder: 'app',
    extend: 'Ext.app.Application',
    requires: [
               'webUi.util.AppSingleton',
               'webUi.util.rb.Bundle',
               'webUi.util.rb.ResourceBundle',
               'Ext.window.MessageBox'
    ],
    views: [
            
    ],

    controllers: [
                  'Main'
    ],

    stores: [
         
    ]
});
