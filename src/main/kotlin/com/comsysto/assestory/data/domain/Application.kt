package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.*

@NodeEntity
data class Application(
        @Id @GeneratedValue var id: Long,
        @Id var name: String,

        @Relationship(type = "USES", direction = Relationship.OUTGOING)
        var resources: MutableList<Resource>)