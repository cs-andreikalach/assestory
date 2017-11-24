// check if petshop application online
match (app {name: 'petshop'})<-[]-(artifact)<-[]-(tomcat {state:'Online'})<-[]-(os {state:'Online'})<-[]-(env {name:'Production'}) return app, artifact, tomcat, os, env

// check if petshop application online
match (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'}) return app, artifact, env
// check if petshop application online and return the path
match path=(app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'}) return path