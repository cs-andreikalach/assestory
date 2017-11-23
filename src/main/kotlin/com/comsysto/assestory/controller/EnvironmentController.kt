package com.comsysto.assestory.controller

import com.comsysto.assestory.data.EnvironmentRepository
import com.comsysto.assestory.data.domain.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EnvironmentController(private val environment: EnvironmentRepository) {

    @GetMapping("/Environment/{name}")
    fun findByName(@PathVariable(value = "name") title: String): Environment? = environment.findByName(title)
}
