
// Environments
CREATE (production:Environment {name:'Production'})
CREATE (test:Environment {name:'Test'})
CREATE (work:Environment {name:'Work'})

// OS
CREATE (linux1:OperatingSystem {host:'linux1.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (linux2:OperatingSystem {host:'linux2.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (linux3:OperatingSystem {host:'linux3.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (linux4:OperatingSystem {host:'linux4.petshop.com', type:'UbuntuLinux', version: '17.10', state: 'Online'})
CREATE (windows1:OperatingSystem {host:'win.petshop.com', type:'WindowsServer', version: '2014', state: 'Online'})

// Environment -> OS
CREATE
  (production)-[:PROVIDES] -> (linux1),
  (production)-[:PROVIDES] -> (linux2),
  (production)-[:PROVIDES] -> (linux3),
  (production)-[:PROVIDES] -> (linux4),
  (production)-[:PROVIDES] -> (windows1)

// Tomcats
CREATE (tomcat1:Tomcat {name:'tpPetshop1', version: '7.0.56', state: 'Online'})
CREATE (tomcat2:Tomcat {name:'tpPetshop2', version: '7.0.56', state: 'Online'})
CREATE (tomcat3:Tomcat {name:'tpPetService1', version: '7.0.56', state: 'Online'})
CREATE (tomcat4:Tomcat {name:'tpStatistic', version: '7.0.56', state: 'Online'})

// Database
CREATE (db1:Database {instance: 'db1'})
CREATE (db2:Database {instance: 'db2'})

// OS -> Tomcats
CREATE
  (linux1)-[:HOSTS {ports:['8080', '8081'], ip:'192.168.20.1', dns:'instance1.petshop.com'}] -> (tomcat1),
  (linux2)-[:HOSTS {ports:['8090', '8091'], ip:'192.168.20.2', dns:'instance2.petshop.com'}] -> (tomcat2),
  (windows1)-[:HOSTS {ports:['80'], ip:'192.168.20.44', dns:'webservice.petshop.com'}] -> (tomcat3),
  (windows1)-[:HOSTS {ports:['8088'], ip:'192.168.20.44', dns:'stat.petshop.com'}] -> (tomcat4)

// OS -> DB
CREATE
  (linux3)-[:HOSTS {ports:['447'], ip:'192.168.30.1', dns:'postgre1.petshop.com'}] -> (db1),
  (linux4)-[:HOSTS {ports:['447'], ip:'192.168.30.2', dns:'postgre2.petshop.com'}] -> (db2)

// Deployment
CREATE (petshop:Deployment {name: 'petshop', version: '2.3.0.2', artifact: 'war'})
CREATE (petshopws:Deployment {name: 'peshopws', version: '1.7.0.0', artifact: 'war'})
CREATE (petshopstatistic:Deployment {name: 'petshopstatistic', version: '1.6.5.2', artifact: 'war'})

// Tomcat -> Deployment
CREATE
    (tomcat1)-[:DEPLOYED {context: ['petshop1']}] -> (petshop),
    (tomcat2)-[:DEPLOYED {context: ['petshop2']}] -> (petshop),
    (tomcat3)-[:DEPLOYED {context: ['pethopws']}] -> (petshopws),
    (tomcat4)-[:DEPLOYED {context: ['petshopstatistic']}] -> (petshopstatistic)

// Deployment -> Database
CREATE
    (petshop)-[:USES] -> (db1),
    (petshop)-[:USES] -> (db2),
    (petshopws)-[:USES] -> (db1),
    (petshopws)-[:USES] -> (db2),
    (petshopstatistic)-[:USES] -> (db1),
    (petshopstatistic)-[:USES] -> (db2)

// Application
CREATE (petshopApp:Application {name: 'petshop'})
CREATE (petshopwsApp:Application {name: 'petshopws'})
CREATE (petshopstatisticApp:Application {name: 'petshopstatistic'})

// Deployment -> Application
CREATE
  (petshop)-[:PROVIDES] -> (petshopApp),
  (petshopws)-[:PROVIDES] -> (petshopwsApp),
  (petshopstatistic)-[:PROVIDES] -> (petshopstatisticApp)


// Service
CREATE (loginservice:Service {name: 'LoginService', protocol: 'https', typ: 'extern'})
CREATE (wetterservice:Service {name:'WetterService', protocol: 'soap', typ: 'extern'})

// Deployment -> Service
CREATE
  (petshop)-[:USES] -> (loginservice),
  (petshop)-[:USES] -> (wetterservice)