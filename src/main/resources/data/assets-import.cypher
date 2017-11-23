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

// Deployment
CREATE (petshop:Deployment {name: 'petshop', version: '2.3.0.2', artifact: 'war'})
CREATE (petshopws:Deployment {name: 'peshopws', version: '1.7.0.0', artifact: 'war'})
CREATE (petshopstatistic:Deployment {name: 'petshopstatistic', version: '1.6.5.2', artifact: 'war'})

// Tomcat -> Deployment
CREATE
    (tomcat1)-[:PROVIDES {context: ['petshop1']}] -> (petshop),
    (tomcat2)-[:PROVIDES {context: ['petshop2']}] -> (petshop),
    (tomcat3)-[:PROVIDES {context: ['pethopws']}] -> (petshopws),
    (tomcat4)-[:PROVIDES {context: ['petshopstatistic']}] -> (petshopstatistic)

// Database
CREATE (db1:Database {instance: 'db1', port: '5432'})
CREATE (db2:Database {instance: 'db2', port: '5432'})

// Deployment -> Database
CREATE
    (petshop)-[:Uses] -> (db1),
    (petshop)-[:Uses] -> (db2),
    (petshopws)-[:Uses] -> (db1),
    (petshopws)-[:Uses] -> (db2),
    (petshopstatistic)-[:Uses] -> (db1),
    (petshopstatistic)-[:Uses] -> (db2)

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
CREATE (loginservice:Service {protocol: 'https', typ: 'extern'})
CREATE (wetterservice:Service {protocol: 'https', typ: 'extern'})

// Deployment -> Service
CREATE
  (petshop)-[:Uses] -> (loginservice),
  (petshop)-[:Uses] -> (wetterservice)



