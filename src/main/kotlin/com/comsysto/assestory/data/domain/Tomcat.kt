package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity(label = "TomcatInstance")
data class Tomcat(@Id var id: Long, var name: String, var title: String) {
}