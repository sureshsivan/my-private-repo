/**
 * Singleton instance of App Loading Indicator
 *  
 */
Ext.define('webUi.util.ui.AppMask', {
	singleton: true,
	loadMask: null,
	activeMasks: null,
	constructor: function(){
//		this.loadMask = Ext.create('Ext.LoadMask', {
//			target: Ext.getBody()
//		});
//		this.loadMask = new Ext.LoadMask(Ext.getBody(), {msg: 'Ayyo'});
//		var ss = new Ext.LoadMask(Ext.getBody(), {msg: 'Ayyo'});
//		ss.show();
		this.activeMasks = Ext.create('Ext.util.HashMap');
	},
	showMask: function(maskKey, maskMsg){
		if(this.isAlreadyActive()){
			this.activeMasks.add(maskKey, msg);
			this.addMessageToMask(msg);
		} else {
			this.activeMasks.add(maskKey, msg);
			this.loadMask.msg = msg;
			this.loadMask.show();
		}
	},
	removeMask: function(maskKey){
		if(this.activeMasks.containsKey(mskkKey)){
			if(this.activeMasks.getCount() == 1){
				this.loadMask.hide();
			} else {
				var msg = this.activeMasks.get(maskKey);
				if(this.activeMasks.removeAtKey(maskKey)){
					this.removeMsgFromMask(msg);
				}
			}
		}
	},
	isAlreadyActive: function(){
		return ((this.loadMask.isVisible()) && (this.activeMasks.getCount() > 0));
	},
	addMessageToMask: function(msg){
		console.log("MESSAGE ADDED");
		console.log(msg);
	}, 
	removeMsgFromMask: function(msg){
		console.log("MESSAGE REMOVED");
		console.log(msg);
	}
	
})