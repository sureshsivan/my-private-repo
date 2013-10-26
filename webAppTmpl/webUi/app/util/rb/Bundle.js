/**
*	courtesy : https://github.com/elmasse/Ext.i18n.Bundle-touch/blob/master/i18n/Bundle.js
**/
Ext.define('webUi.util.rb.Bundle', {
        extend: 'Ext.data.Store',
        requires: [
                   'webUi.util.rb.model.KeyValPair'
        ],
        //@private
        defaultLanguage: 'en-US',
        //@private
        resourceExt: '.properties',
        
        config:{
                /**
                 * @cfg bundle {String} bundle name for properties file. Default to message  
                 */
                bundle: 'message',

                /**
                 * @cfg path {String} URI to properties files. Default to resources
                 */
                path: 'resources'

                /**
                 * @cfg lang {String} Language in the form xx-YY where:
                 *                 xx: Language code (2 characters lowercase) 
                 *     			   YY: Country code (2 characters upercase). 
                 * Optional. Default to browser's language. If it cannot be determined default to en-US.
                 */
                
                /**
                 * @cfg noCache {boolean} whether or not to disable Proxy's cache. Optional. Defaults to true. 
                 */
                
        },
        
        
        constructor: function(config){
                config = config || {};

                var me = this,
                        language = me.formatLanguageCode(config.lang || me.guessLanguage()),
                        noCache = (config.noCache !== false),
                        url;

                me.language = language;
                me.bundle = config.bundle || me.bundle;
                me.path = config.path || me.path;
                        
                url = this.buildURL(language);

                delete config.lang;
                delete config.noCache;
                
                Ext.applyIf(config, {
                        autoLoad: true,
                        model: 'webUi.util.rb.model.KeyValPair',
                        proxy:{
                                type: 'ajax',
                                url: url,
                                noCache: noCache,
                                reader: {
                                        type: 'json'
                                },
                                //avoid sending limit, start & group params to server
                                getParams: Ext.emptyFn
                        },
                        listeners:{
                                'load': this.onBundleLoad,
                                scope: this
                        }
                });

                me.callParent([config]);
                me.getProxy().on('exception', this.loadParent, this, {single: true});
        },
        
        /**
         * @private
         */
        guessLanguage: function(){
                return (navigator.language || navigator.browserLanguage
                                || navigator.userLanguage || this.defaultLanguage);
        },
        
        /**
         * @method: getMsg
         * Returns the content associated with the bundle key or {bundle key}.undefined if it is not specified.
         * @param: key {String} Bundle key.
         * @return: {String} The bundle key content. 
         */
        getMsg: function(key){
                return this.getById(key)? Ext.util.Format.htmlDecode(this.getById(key).get('value')) : key + '.undefined';
        },
        
        /**
         * @method: onReady
         * The fn will be called when the Bundle file is loaded.
         * @param: fn {Function}
         */
        onReady: function(fn){
                this.readyFn = fn;
                this.on('loaded', this.readyFn, this);
        },
        
        onLoadError: function(fn){
        	this.errFn = fn;
            this.on('loadError', this.errFn, this);
        },
        
        /**
         * @private
         */
        onBundleLoad: function(store, record, success, op) {
        		console.log(store);
        		console.log(record);
        		console.log(success);
        		console.log(op);
                if(success){
                        this.fireEvent('loaded');
                } else{
                	this.fireEvent('loadError');
                }
        },

        dumpToStore: function(data){
        	console.log(data);
        },
        
        /**
         * @private
         */
        onProxyLoad: function(op){
                if(op.getRecords()){
                        this.callParent(arguments);
                }
        },
        
        /**
         * @private
         */
        buildURL: function(language){
                var url = '';
                if (this.path) url+= this.path + '/';
                url+=this.bundle;
                if (language) url+= '_'+language;
                url+=this.resourceExt;
                return url;
        },
        
        /**
         * @private
         */
        loadParent: function(){
                this.getProxy().setUrl(this.buildURL());
                this.load();                        
        },
        
        /**
         * @private
         */
        formatLanguageCode: function(lang){
                var langCodes = lang.split('-');
                langCodes[0] = (langCodes[0]) ? langCodes[0].toLowerCase() : '';
                langCodes[1] = (langCodes[1]) ? langCodes[1].toUpperCase() : '';
                return langCodes.join('-');
        }
        
        
        
});