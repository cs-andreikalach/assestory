package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.Application
import com.comsysto.assestory.data.domain.State
import org.neo4j.driver.internal.InternalPath
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ApplicationRepository : CrudRepository<Application, String> {

    @Query("match path=(app {name: {name}})<-[]-(artifact:Deployment)<-[]-(tomcat:Tomcat {state:'Online'})<-[]-(os:OperatingSystem {state:'Online'})<-[]-(env {name:'Production'}) return count(path)>0")
    fun findApplicationStateByName(@Param("name") name: String): Boolean

    @Query("MATCH (e:Environment {name:{environmentName}}), (a:Application {name: {applicationName}}), ps = ((e)-[*..5]-(a)) WHERE ALL(p IN nodes(ps) WHERE p.state = {state}) RETURN ps")
    fun findPathsByState(@Param("environmentName") environmentName: String, @Param("applicationName") applicationName: String, @Param("state") state: State): List<Map<String, InternalPath>>
}