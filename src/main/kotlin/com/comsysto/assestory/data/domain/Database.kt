package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class Database(
        @Id @GeneratedValue override var id: Long,
        @Id var instance: String,
        override var state: State) : StateEntity()