package com.comsysto.assestory.data.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "DEPLOYED")
data class DeployedRelation(
        @Id @GeneratedValue var id: Long,
        var context:  MutableList<String>,

        @JsonIgnore @StartNode var tomcat: Tomcat,
        @EndNode var deployment: Deployment)