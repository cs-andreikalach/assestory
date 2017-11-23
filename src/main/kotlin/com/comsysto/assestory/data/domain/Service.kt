package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Service(
        @Id var name: String,
        var protocol: Protocol,
        var serviceType: ServiceType,
        override var state: State) : StateEntity()