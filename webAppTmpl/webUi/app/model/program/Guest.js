/**
 * 
 * 
 */
Ext.define('webUi.model.program.Guest', {
	extend : 'Ext.data.Model',
	config: {
		fields: [
		         'guestName',
		         'gender',
		         {name: 'age', type:'int'}
		]
	}
})