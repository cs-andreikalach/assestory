package com.comsysto.assestory.controller

import com.comsysto.assestory.data.ApplicationRepository
import com.comsysto.assestory.data.domain.State
import com.comsysto.assestory.view.ApplicationView
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ApplicationController(private val appRepository: ApplicationRepository) {
    @GetMapping(value = "/Applications", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    fun findAll() = appRepository.findAll().map {
        ApplicationView(it.name,
                appRepository.findApplicationStateByName(it.name).toState())
    }

    @GetMapping(value = "/Applications", produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    fun findAllView(model: Model): String {
        model.addAttribute("applications", appRepository.findAll())
        return "applications"
    }
}

fun Boolean.toState(): State {
    return if (this) State.Online else State.Offline
}