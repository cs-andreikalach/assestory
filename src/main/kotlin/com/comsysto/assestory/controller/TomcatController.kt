package com.comsysto.assestory.controller

import com.comsysto.assestory.data.TomcatRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TomcatController(private val repository: TomcatRepository) {
    @GetMapping("/tomcats")
    fun getList() = repository.findAll()
}
