/**
 * This is the Logo Widget placed in Footer
 */
 Ext.define('webUi.view.common.FooterLogo', {
	    extend: 'Ext.Component',
	    xtype: 'd-footer-logo',
	    bodyPadding : '2 2 2 2',
//	    margin: 2,
	    border: false,
	    layout: {
	        type: 'vbox',
	        align: 'right'
	    },
	    items: [
	        {
	        	//html: '<img src="img/footer-logo.png">',
	        	html: '<img src="' + webUi.util.AppSingleton.getAppParam('app.footer.logoPath') + '">',
	        	border: false
//				xtype: 'component',
//				autoEl: {
//					tag: 'img',
//					src: webUi.util.AppSingleton.getAppParam('app.footer.logoPath')
//				}
	        }
	    ]
	});