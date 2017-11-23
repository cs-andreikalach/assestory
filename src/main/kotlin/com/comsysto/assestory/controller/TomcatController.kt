package com.comsysto.assestory.controller

import com.comsysto.assestory.data.EnvironmentRepository
import com.comsysto.assestory.data.TomcatRepository
import com.comsysto.assestory.data.domain.Environment
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller
class TomcatController(private val tomcatRepository: TomcatRepository) {
    @GetMapping(value = "/Tomcats", produces = arrayOf(APPLICATION_JSON_VALUE))
    @ResponseBody
    fun findAll() = tomcatRepository.findAll()

    @GetMapping(value = "/Tomcats", produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    fun findAllView(model : Model) : String {
        model.addAttribute("tomcats", tomcatRepository.findAll())
        return "tomcats"
    }
}