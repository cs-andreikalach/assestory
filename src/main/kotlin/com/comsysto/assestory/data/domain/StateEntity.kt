package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
abstract class StateEntity {
    abstract var id: Long
    abstract var state: State
}