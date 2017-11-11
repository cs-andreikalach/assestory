package com.comsysto.assestory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@SpringBootApplication(exclude = arrayOf(RepositoryRestMvcAutoConfiguration::class))
@EnableWebMvc
//@SpringBootApplication
@EnableNeo4jRepositories
open class AssestoryApplication {
}

fun main(args: Array<String>) {
    runApplication<AssestoryApplication>(*args)
}

