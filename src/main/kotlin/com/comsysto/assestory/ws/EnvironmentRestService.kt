package com.comsysto.assestory.ws

import com.comsysto.assestory.data.EnvironmentRepository
import com.comsysto.assestory.data.OnlineConfigGroupRepository
import com.comsysto.assestory.data.domain.Environment
import com.comsysto.assestory.data.domain.OnlineConfigGroup
import com.comsysto.assestory.data.domain.SystemState
import com.comsysto.assestory.service.MonitoringService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EnvironmentRestService(
        private val monitoringService: MonitoringService,
        private val environment: EnvironmentRepository,
        private val onlineConfigGroupRepository: OnlineConfigGroupRepository) {

    // curl http://localhost:8080/Environment/Production
    @GetMapping("/Environment/{name}")
    fun findByName(@PathVariable(value = "name") name: String): Environment? = environment.findByName(name)

    // curl http://localhost:8080/Application/petshop/OnlineConfigGroup
    @GetMapping("/Application/{name}/OnlineConfigGroup")
    fun findConfigEnvironmentByName(@PathVariable(value = "name") name: String): List<OnlineConfigGroup> = onlineConfigGroupRepository.findByApplication(name)

    // curl http://localhost:8080/Environment/Production/offline
    @GetMapping("/Environment/{name}/offline")
    fun findOfflineConfiguration(@PathVariable(value = "name") name: String): List<String>? {
        return null
    }

    // curl http://localhost:8080/SystemState/Environment/Production/Application/petshop
    @GetMapping("/SystemState/Environment/{environmentName}/Application/{applicationName}")
    fun findSystemState(@PathVariable(value = "environmentName") environmentName: String, @PathVariable(value = "applicationName") applicationName: String): SystemState =
            monitoringService.findSystemState(environmentName, applicationName)


}

