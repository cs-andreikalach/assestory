package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Deployment(
        @Id @GeneratedValue override var id: Long,
        @Id var name: String,
        var version: String,
        var artifact: Artifact,

        @Relationship(type = "USES", direction = Relationship.OUTGOING)
        var databases: MutableList<Database>?,

        @Relationship(type = "USES", direction = Relationship.OUTGOING)
        var services: MutableList<Service>?,

        @Relationship(type = "PROVIDES", direction = Relationship.OUTGOING)
        var application: Application,

        override var state: State) : StateEntity()