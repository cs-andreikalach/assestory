package com.comsysto.assestory.data.domain

import org.neo4j.ogm.annotation.*

//@RelationshipEntity(type = "HOSTS")
data class HostsTomcatRelation(
        @Id @GeneratedValue var id: Long,
        override var dns: String,
        override var ip: String,
        override var post: Int,

        @StartNode var operatingSystem: OperatingSystem,
        @EndNode var tomcat: Tomcat) : HostsRelation()