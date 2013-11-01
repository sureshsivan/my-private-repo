/**
 * This is the Copyright Widget placed in Footer
 */
Ext.define('webUi.view.common.Copyright', {
    extend: 'Ext.container.Container',
    xtype: 'd-copyright',
    margin: 2,
    border: false,
    layout: {
        type: 'fit'
    },
    html: webUi.util.AppSingleton.getMsg('app.copyright'),
    padding: '0 0 0 20'
});