package com.example.debatematch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@ConfigurationPropertiesScan
@SpringBootApplication
@EnableFeignClients
class DebateMatchApplication

fun main(args: Array<String>) {
    runApplication<DebateMatchApplication>(*args)
}
