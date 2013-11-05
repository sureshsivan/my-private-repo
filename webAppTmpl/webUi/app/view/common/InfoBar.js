/**
 * This is the Header before user login
 */
Ext.define('webUi.view.common.InfoBar', {
    extend: 'Ext.container.Container',
    xtype: 'd-infobar',
//    singleton: true,
    id: 'infoBar',
    minHeight: 40,
    width: '100%',
	border: 0,
	cls: 'infoBar',
	clearItems: function(){
		console.log('[InfoBar] clearing Items...........');
	}
});
