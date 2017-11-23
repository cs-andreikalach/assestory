package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.Environment
import com.comsysto.assestory.data.domain.Tomcat
import org.springframework.data.neo4j.annotation.Depth
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EnvironmentRepository : CrudRepository<Environment, String> {

    //@Query("MATCH (e:Environment)-[*]->(o:OperatingSystem)-[*]->(t:Tomcat) WHERE e.name={name} RETURN e")
    @Depth(10)
    fun findByName(@Param("name") name: String): Environment
}