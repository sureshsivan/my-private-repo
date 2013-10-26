/**
 * 
 * 
 */
Ext.define('webUi.model.program.Guest', {
	extend : 'Ext.data.model',
	config: {
		fields: [
		         'guestName',
		         'gender',
		         {name: 'age', type:'int'}
		]
	}
})