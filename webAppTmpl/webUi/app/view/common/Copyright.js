/**
 * This is the Copyright Widget placed in Footer
 */
Ext.define('webUi.view.common.Copyright', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-copyright',
    bodyPadding : '2 2 2 2',
    margin: 2,
    border: false,
    layout: {
        type: 'fit'
    },
    //html: 'Copyright © 2013 <a href="http://www.v8-delta.com">v8-delta</a> Company. All Rights Reserved.'
    html: webUi.util.AppSingleton.getMsg('app.copyright')
});