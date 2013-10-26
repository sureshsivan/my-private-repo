Ext.define('webUi.Application', {
    name: 'webUi',
    appFolder: 'app',
    extend: 'Ext.app.Application',
    requires: [
               'webUi.util.AppSingleton',
               'webUi.util.rb.Bundle'
    ],
    views: [
            
    ],

    controllers: [
                  'Main'
    ],

    stores: [
         
    ]
});
