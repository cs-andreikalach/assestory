// check if petshop application online
match (app {name: 'petshop'})<-[]-(artifact)<-[]-(tomcat {state:'Online'})<-[]-(os {state:'Online'})<-[]-(env {name:'Production'}) return app, artifact, tomcat, os, env

// check if petshop application online
match (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'}) return app, artifact, env
// check if petshop application online and return the path
match path=(app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'}) return path
// check if petshop application online and return the path -> return true if path exists else false
match path=(app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'}) return count(path) > 0
// check if petshop application online and return the path -> Typen der gefundenen nodes ausgeben
match path=(app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state:'Online'})<-[]-(env {name:'Production'})
WITH NODES(path) AS nodes
WITH REDUCE(myTypes = [], node in nodes | myTypes + labels(node)) as myTypes
RETURN DISTINCT myTypes