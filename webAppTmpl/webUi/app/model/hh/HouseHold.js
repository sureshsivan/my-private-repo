/**
* Model Instance for Household member
**/
Ext.define('webUi.model.hh.HouseHold', {
	extend : 'Ext.data.model',
	config: {
		fields: [
		         'hhid',
		         {name: 'isHispLatSpanOrigin', type: 'boolean'},
		         {name: 'totTvs', type: 'int'},
		         {name: 'workingTvs', type: 'int'},
		         {name: 'hasWorkingCellPhone', type: 'boolean'},
		         {name: 'hasLandLinePhone', type: 'boolean'},
		         {name: 'zipcode', type: 'int'},
		         
		],
		hasMany: [
		          {name: 'members', model: 'webUi.model.hh.HhMember'},
		          {name: 'races', model: 'webUi.model.hh.Race'},
		          {name: 'tvs', model: 'webUi.model.hh.Tv'},
		],
		hasOne: [
		         {name: 'county', model: 'webUi.model.hh.County'},
		],
		idProperty: 'hhid'
	}
});