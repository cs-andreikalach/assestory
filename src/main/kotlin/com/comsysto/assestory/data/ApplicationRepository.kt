package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.Application
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ApplicationRepository : CrudRepository<Application, String> {
    @Query("match path=(app {name: {name}})<-[]-(artifact:Deployment)<-[]-(tomcat:Tomcat {state:'Online'})<-[]-(os:OperatingSystem {state:'Online'})<-[]-(env {name:'Production'}) return count(path)>0")
    fun findApplicationStateByName(@Param("name") name: String): Boolean
}