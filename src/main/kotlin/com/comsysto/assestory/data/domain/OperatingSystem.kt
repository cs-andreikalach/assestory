package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class OperatingSystem(
        @Id var host: String,
        var type: OsType,
        var version: String,
        override var state: State,

        @Relationship(type = "HOSTS", direction = Relationship.OUTGOING)
        var tomcats: MutableList<Tomcat>?,

        @Relationship(type = "HOSTS", direction = Relationship.OUTGOING)
        var databases: MutableList<Database>?,

        @Relationship(type = "HOSTS", direction = Relationship.OUTGOING)
        var services: MutableList<Service>?

) : StateEntity()