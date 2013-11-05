/**
* Model Instance for Household member
**/
Ext.define('webUi.model.hh.HhMember', {
	extend : 'Ext.data.Model',
	config: {
		fields: [
		         'id',
		         'fname',
		         'lname',
		         'email',
		         'gender',
		         {name: 'age', type: 'int'},
		         'lang',
		         {name: 'hrsWrkPerWeek', type: 'int'},
		         {name: 'isOwnHouse', type: 'boolean'},
		         'mobNo',
		         {name: 'isHead', type: 'boolean'},
		         {name: 'isCurrentUser', type: 'boolean'}
		]
	}
});