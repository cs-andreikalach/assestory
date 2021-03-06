package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Tomcat(
        @Id @GeneratedValue override var id: Long,
        @Id var name: String,
        var version: String,

        @Relationship(type = "DEPLOYED", direction = Relationship.OUTGOING)
        var deployments: MutableList<DeployedRelation>?,

        override var state: State): StateEntity()