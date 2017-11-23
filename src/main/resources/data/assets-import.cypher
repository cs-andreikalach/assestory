// Environments
CREATE (Production:Environment {title:'Production'})
CREATE (Test:Environment {title:'Test'})
CREATE (Work:Environment {title:'Work'})

// OS
CREATE (Linux1:OperatingSystem {host:'linux1.petshop.com', type:'UbuntuLinux', version: '17.10'})
CREATE (Linux2:OperatingSystem {host:'linux2.petshop.com', type:'UbuntuLinux', version: '17.10'})
CREATE (Windows1:OperatingSystem {host:'win.petshop.com', type:'WindowsServer', version: '2014'})

// Environment -> OS
CREATE
  (Production)-[:PROVIDES] -> (Linux1),
  (Production)-[:PROVIDES] -> (Linux2),
  (Production)-[:PROVIDES] -> (Windows1)

// Tomcats
CREATE (Tomcat1:Tomcat {title:'tpPetshop1', version: '7.0.56'})
CREATE (Tomcat2:Tomcat {title:'tpPetshop2', version: '7.0.56'})
CREATE (Tomcat3:Tomcat {title:'tpPetService1', version: '7.0.56'})
CREATE (Tomcat4:Tomcat {title:'tpStatistic', version: '7.0.56'})

// OS -> Tomcats
CREATE
  (Linux1)-[:HOSTS {ports:['8080', '8081'], ip:'192.168.20.1', dns:'instance1.petshop.com'}] -> (Tomcat1),
  (Linux2)-[:HOSTS {ports:['8090', '8091'], ip:'192.168.20.2', dns:'instance2.petshop.com'}] -> (Tomcat2),
  (Windows1)-[:HOSTS {ports:['80'], ip:'192.168.20.44', dns:'webservice.petshop.com'}] -> (Tomcat3),
  (Windows1)-[:HOSTS {ports:['8088'], ip:'192.168.20.44', dns:'stat.petshop.com'}] -> (Tomcat4)