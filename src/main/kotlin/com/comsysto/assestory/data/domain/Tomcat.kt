package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class Tomcat(@Id var name: String, var version: String, override var state: State) : StateEntity()