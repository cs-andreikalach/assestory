package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.OnlineConfig
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OnlineConfigRepository : CrudRepository<OnlineConfig, String> {

    @Query("MATCH (a:Application)<-[*]-(:OnlineConfigGroup)-[*]->(o:OnlineConfig) WHERE a.name={applicationName} RETURN o")
    fun findByApplicationName(@Param("applicationName") applicationName: String): List<OnlineConfig>

    fun findByName(@Param("name") name: String): List<OnlineConfig>
}