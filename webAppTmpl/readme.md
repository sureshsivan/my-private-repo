This is template which can be used to create a web app. 
Core app is a normal maven project and the app is divided into sub modules.
[This is for Personal Use]

Highlights of this app
----------------------
* This is a multi module maven app.
* Uses spring as bean container and uses spring mvc 
* Uses myBatis as DAO layer(Choose myBatis over hibernate as myBatis is lightweight. Also really would like to have 
    own sql queries instead of using HQL.)
* Uses apache dbcp for connection pooling.
* Uses jquery javascript library ajax and other client side codes.
* Uses bootstrap for ui-desigh and responsive design.
* ... and many more.. will add eventually.(most of them mentioned above is not implemented. Thats what I have in my mind.. :))

This app is subdivided into modules.
jspUtils - All custom tags will go here.
services - All Persistance services will go here
model - All model object will be placed here(This is not a good idea. Need to lookout for a abetter option).
web - All Web module related source stays here

This Project uses below tools 
-----------------------------
###### Spring [version:]
###### Maven [version:]
###### myBatis [version:]
###### jQuery [version:]
###### twitter bootstrap [version:]
###### maven - as build tool


