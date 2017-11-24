package com.comsysto.assestory.controller

import com.comsysto.assestory.data.TomcatRepository
import com.comsysto.assestory.data.domain.State
import com.comsysto.assestory.data.domain.Tomcat
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest


@Controller
class TomcatController(private val tomcatRepository: TomcatRepository) {
    @GetMapping(value = "/Tomcats", produces = arrayOf(APPLICATION_JSON_VALUE))
    @ResponseBody
    fun findAll() = tomcatRepository.findAll()

    @GetMapping(value = "/Tomcats", produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    fun findAllView(model: Model): String {
        model.addAttribute("tomcats", tomcatRepository.findAll())
        return "tomcats"
    }

    @RequestMapping(value = "/maintenance", method = arrayOf(RequestMethod.POST))
    fun postSearch(request: HttpServletRequest): String {
        val tomcatId = request.getParameter("tomcat_id")
        val tomcatInstance : Tomcat = tomcatRepository.findById(tomcatId).get()
        tomcatInstance.state = if (tomcatInstance.state == State.Offline) State.Online else State.Offline
        tomcatRepository.save(tomcatInstance)

        return "redirect:Tomcats"
    }
}