package com.comsysto.assestory.data.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "HOSTS")
data class HostsTomcatRelation(
        @Id @GeneratedValue var id: Long,
        override var dns: String,
        override var ip: String,
        override var ports: MutableList<String>,

        @JsonIgnore @StartNode var operatingSystem: OperatingSystem,
        @EndNode var tomcat: Tomcat) : HostsRelation() {

    override fun equals(other: Any?): Boolean {
        other as HostsTomcatRelation
        return this.dns == other.dns
    }

    override fun hashCode() = this.dns.hashCode()
    override fun toString(): String = dns
}