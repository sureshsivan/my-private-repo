/**
*	Model whick holds the key value pair used in application params and 
* 	Resource Bundles.
* 
* 	courtesy from : https://github.com/elmasse/Ext.i18n.Bundle-touch/blob/master/i18n/model/Property.js
* 
**/
Ext.define('webui.model.KeyValPair', {
        extend: 'Ext.data.Model',
        config: {
                idProperty: 'key',
                fields: ['key', 'value']
        }

});