/**
 * Model Instance for Household member
 */
Ext.define('webUi.model.hh.Tv', {
	extend : 'Ext.data.model',
	config: {
		fields: [
				 'id',
				 'tvName',
				 'tvType',
				 'cabSerProvider',
				 {name: 'isDigCabSetTopBoxAttached', type: 'boolean'},
				 'satSerProvider',
				 {name: 'isFourFeetOrLong', type: 'boolean'},
				 {name: 'hasLocalBroadcastStns', type: 'boolean'},
				 {name: 'isHd', type: 'boolean'},
				 {name: 'isPrimary', type: 'boolean'},
		],
		hasMany: [
		         {name: 'extraFeeChannels', model: 'webUi.model.hh.Channel'},
		         {name: 'connectedDevices', model: 'webUi.model.hh.Device'}
		]
	}
});