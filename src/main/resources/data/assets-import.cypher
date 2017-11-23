// Environments
CREATE (production:Environment {name:'Production'})
CREATE (test:Environment {name:'Test'})
CREATE (work:Environment {name:'Work'})

// OS
CREATE (linux1:OperatingSystem {host:'linux1.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (linux2:OperatingSystem {host:'linux2.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (windows1:OperatingSystem {host:'win.petshop.com', type:'WindowsServer', version: '2014', state: 'Online'})

// Environment -> OS
CREATE
  (production)-[:PROVIDES] -> (linux1),
  (production)-[:PROVIDES] -> (linux2),
  (production)-[:PROVIDES] -> (windows1)

// Tomcats
CREATE (tomcat1:Tomcat {name:'tpPetshop1', version: '7.0.56', state: 'Online'})
CREATE (tomcat2:Tomcat {name:'tpPetshop2', version: '7.0.56', state: 'Online'})
CREATE (tomcat3:Tomcat {name:'tpPetService1', version: '7.0.56', state: 'Online'})
CREATE (tomcat4:Tomcat {name:'tpStatistic', version: '7.0.56', state: 'Online'})

// OS -> Tomcats
CREATE
  (linux1)-[:HOSTS {ports:['8080', '8081'], ip:'192.168.20.1', dns:'instance1.petshop.com'}] -> (tomcat1),
  (linux2)-[:HOSTS {ports:['8090', '8091'], ip:'192.168.20.2', dns:'instance2.petshop.com'}] -> (tomcat2),
  (windows1)-[:HOSTS {ports:['80'], ip:'192.168.20.44', dns:'webservice.petshop.com'}] -> (tomcat3),
  (windows1)-[:HOSTS {ports:['8088'], ip:'192.168.20.44', dns:'stat.petshop.com'}] -> (tomcat4)