package com.comsysto.assestory.service

import com.comsysto.assestory.data.ApplicationRepository
import com.comsysto.assestory.data.OnlineConfigGroupRepository
import com.comsysto.assestory.data.domain.OnlineConfig
import com.comsysto.assestory.data.domain.OnlineConfigGroup
import com.comsysto.assestory.data.domain.State
import com.comsysto.assestory.data.domain.SystemState
import org.neo4j.driver.internal.InternalPath
import org.springframework.stereotype.Service

@Service
class MonitoringService(private val onlineConfigGroupRepository: OnlineConfigGroupRepository, private val applicationRepository: ApplicationRepository) {

    fun findSystemState(environmentName: String, applicationName: String): SystemState {
        var onlinePaths: List<InternalPath?> = applicationRepository.findPathsByState(environmentName, applicationName, State.Online).map { v -> v["ps"] }
        var config: OnlineConfigGroup = onlineConfigGroupRepository.findByApplicationAndEnvironment(applicationName, environmentName)

        val online: MutableSet<String> = mutableSetOf()
        val offline: MutableSet<String> = mutableSetOf()

        for (conf: OnlineConfig in config.configs) {
            for (path: InternalPath? in onlinePaths) {
                if (hasConfig(path, conf)) {
                    online.add(conf.name)
                } else {
                    offline.add(conf.name)
                }
            }
        }
        offline.removeAll(online)
        return SystemState(online, offline)
    }

    fun hasConfig(path: InternalPath?, conf: OnlineConfig): Boolean {
        return conf.states.map { s -> s.id }.any { path?.nodes()?.any { node -> node.id() == it }!! }
    }

}