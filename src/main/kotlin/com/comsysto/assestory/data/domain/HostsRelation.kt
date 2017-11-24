package com.comsysto.assestory.data.domain

abstract class HostsRelation {
    abstract var dns: String
    abstract var ip: String
    abstract var ports: MutableList<String>
}