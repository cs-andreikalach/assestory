package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Application(
        @Id var name: String,

        @Relationship(type = "USES", direction = Relationship.OUTGOING)
        var os: MutableList<Resource>)