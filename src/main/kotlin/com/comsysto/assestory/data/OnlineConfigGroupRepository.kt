package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.OnlineConfig
import com.comsysto.assestory.data.domain.OnlineConfigGroup
import org.springframework.data.neo4j.annotation.Depth
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OnlineConfigGroupRepository : CrudRepository<OnlineConfigGroup, String> {

    @Query("MATCH (a:Application)<-[:CONFIG]-(o:OnlineConfigGroup)-[:CONFIG]->(e:Environment) WHERE a.name = {applicationName} AND e.name={environmentName} RETURN o,(o)-[:EL]->(:OnlineConfig)-[:ONLINE]->()")
    fun findByApplicationAndEnvironment(@Param("applicationName") applicationName: String, @Param("environmentName") environmentName: String): OnlineConfigGroup

    @Query("MATCH (a:Application)<-[:CONFIG]-(o:OnlineConfigGroup) WHERE a.name={applicationName} RETURN o")
    fun findByApplication(@Param("applicationName") applicationName: String): List<OnlineConfigGroup>

    fun findByName(@Param("name") name: String): List<OnlineConfigGroup>
}