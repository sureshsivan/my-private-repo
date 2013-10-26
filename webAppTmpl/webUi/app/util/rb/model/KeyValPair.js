Ext.define('webUi.util.rb.model.KeyValPair', {
        extend: 'Ext.data.Model',
        config: {
                idProperty: 'key',
                fields: ['key', 'val']
        }

});