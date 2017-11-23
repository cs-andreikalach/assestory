package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class Database(
    @Id var instance: String,
    var port: Int,
    override var state: State) : StateEntity()