package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.annotation.Id

@NodeEntity(label = "TomcatInstance")
data class Tomcat(@org.neo4j.ogm.annotation.Id @Id var id: Long, var name: String, var title: String) {
}