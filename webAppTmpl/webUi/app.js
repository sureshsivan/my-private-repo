/*
    This file is generated and updated by Sencha Cmd. You can edit this file as
    needed for your application, but these edits will have to be merged by
    Sencha Cmd when upgrading.
*/

// DO NOT DELETE - this directive is required for Sencha Cmd packages to work.
//@require @packageOverrides

Ext.application({
    name: 'webUi',
    extend: 'webUi.Application',
    autoCreateViewport: true,
    launch: startAppLaunch
});

function startAppLaunch(){
	console.log('#########');
//	var vp = new webUi.view.Viewport(),
//	    rp = new webUi.view.Rootpanel();
//	vp.add(rp);
	console.log('@@@@@@@@@');
	
	console.log('Before Firing Event appStart');
	webUi.getApplication().fireEvent('appStart');
	console.log('After Firing Event appStart');
	
}