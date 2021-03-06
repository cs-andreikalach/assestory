package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class OnlineConfigGroup(
        @Id @GeneratedValue var id: Long,
        @Id var name: String,

        @Relationship(type = "EL")
        var configs: MutableList<OnlineConfig>
)