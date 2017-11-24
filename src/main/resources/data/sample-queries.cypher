// check if petshop application online
MATCH(app {name: 'petshop'})<-[]-(artifact)<-[]-(tomcat {state: 'Online'})<-[]-(os {state: 'Online'})
       <-[]-(env {name: 'Production'})
RETURN app, artifact, tomcat, os, env

// check if petshop application online
MATCH (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state: 'Online'})<-[]-(env {name: 'Production'})
RETURN app, artifact, env
// check if petshop application online and return the path
MATCH path = (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state: 'Online'})<-[]-(env {name: 'Production'})
RETURN path
// check if petshop application online and return the path -> return true if path exists else false
MATCH path = (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state: 'Online'})<-[]-(env {name: 'Production'})
RETURN count(path) > 0
// check if petshop application online and return the path -> Typen der gefundenen nodes ausgeben
MATCH path = (app {name: 'petshop'})<-[]-(artifact)<-[*1..10]-({state: 'Online'})<-[]-(env {name: 'Production'})
WITH nodes(path) AS nodes
WITH reduce(myTypes = [], node IN nodes | myTypes + labels(node)) AS myTypes
RETURN DISTINCT myTypes


MATCH path = (ap:Application {name: 'petshop'})<-[]-(dp:Deployment {state: 'Online'})<-[]-(tm:Tomcat {state: 'Online'})
  <-[]-(os:OperatingSystem {state: 'Online'})<-[]-(en:Environment {name: 'Production'})
RETURN ap, dp, tm, os, en


// set one not to Offline
match (o:OperatingSystem {host: 'linux2.petshop.com'}) set o.state='Offline'

// Find shortest path between two nodes with intermediate nodes that have status Online
MATCH (e:Environment {name:'Production'}), (t:Tomcat), p = shortestPath((e)-[*]-(t)) WHERE t.name IN ['tpPetshop1', 'tpPetshop2'] RETURN filter(n IN nodes(p) WHERE n.state='Online' OR n.state = NULL),e,t