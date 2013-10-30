/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.GuestHeader', {
    extend: 'Ext.panel.Panel',
    requires:[
        'Ext.layout.container.Border'
    ],
    xtype: 'd-guest-header',
    //html: '<img class="header-logo" src="/img/logo.png"/>'
    html: '<img class="header-logo" src="' + webUi.util.AppSingleton.getAppParam('app.header.logoPath') + '">',
});