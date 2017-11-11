package com.comsysto.controller

import com.comsysto.assestory.data.TomcatRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class TomcatController(private val repository: TomcatRepository) {
    @RequestMapping("/tomcats", method = arrayOf(RequestMethod.GET))
    fun getList(model: Model): String {
        model.addAttribute("tomcats", repository.findAll())
        return "tomcats"
    }
}
