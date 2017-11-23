CREATE (Production:Environment {title:'Production'})
CREATE (Test:Environment {title:'Test'})
CREATE (Work:Environment {title:'Work'})

CREATE (Linux1:OperatingSystem {host:'linux1.petshop.com', type:'Ubuntu Linux', version: '17.10'})
CREATE (Linux2:OperatingSystem {host:'linux2.petshop.com', type:'Ubuntu Linux', version: '17.10'})
CREATE (Windows1:OperatingSystem {host:'win.petshop.com', type:'Windows Server', version: '2014'})

CREATE
  (Linux1)-[:PROVIDED_IN] -> (Production),
  (Linux2)-[:PROVIDED_IN] -> (Production),
  (Windows1)-[:PROVIDED_IN] -> (Production)

CREATE (Tomcat1:Tomcat {title:'tpPetshop1', version: '7.0.56'})
CREATE (Tomcat2:Tomcat {title:'tpPetshop2', version: '7.0.56'})
CREATE (Tomcat3:Tomcat {title:'tpPetService1', version: '7.0.56'})

CREATE
  (Linux1)-[:PROVIDED_IN] -> (Production),
  (Linux2)-[:PROVIDED_IN] -> (Production),
  (Windows1)-[:PROVIDED_IN] -> (Production)