/**
 * This is the Logo Widget placed in Footer
 */
 Ext.define('webUi.view.common.FooterLogo', {
	    extend: 'Ext.container.Container',
	    xtype: 'd-footer-logo',
	    border: false,
	    layout: {
	        type: 'vbox',
	        align: 'right'
	    },
	    items: [
	        {
        		xtype: 'container',
//        		html: '<img src="' + webUi.util.AppSingleton.getAppParam('app.footer.logoPath') + '">'
        		html: 'Fix Issue with imag Path......',
        		padding: '0 20 0 0'
	        }
	    ]
	});