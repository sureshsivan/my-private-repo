/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.InfoBar', {
    extend: 'Ext.panel.Panel',
    xtype: 'd-info-bar',
    itemId: 'infoBar',
    minHeight: 40,
    width: '100%',
	border: true,
	html: 'Info Bar',
	bodyPadding: '0 5 0 5'
});
