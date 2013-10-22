# webUi/app

This folder contains the javascript files for the application.

# webUi/resources

This folder contains static resources (typically an `"images"` folder as well).

# webUi/overrides

This folder contains override classes. All overrides in this folder will be 
automatically included in application builds if the target class of the override
is loaded.

# webUi/sass/etc

This folder contains misc. support code for sass builds (global functions, 
mixins, etc.)

# webUi/sass/src

This folder contains sass files defining css rules corresponding to classes
included in the application's javascript code build.  By default, files in this 
folder are mapped to the application's root namespace, 'webUi'. The
namespace to which files in this directory are matched is controlled by the
app.sass.namespace property in webUi/.sencha/app/sencha.cfg. 

# webUi/sass/var

This folder contains sass files defining sass variables corresponding to classes
included in the application's javascript code build.  By default, files in this 
folder are mapped to the application's root namespace, 'webUi'. The
namespace to which files in this directory are matched is controlled by the
app.sass.namespace property in webUi/.sencha/app/sencha.cfg. 



## Suresh
## Used "sench app build" to build the application - Ruby, Compass installation is mandatory or some config change is required.
## 
## >> Planning to create ant build and copy the contents from webUi to web folder.
## >> Create this project as one of the maven module for main project.