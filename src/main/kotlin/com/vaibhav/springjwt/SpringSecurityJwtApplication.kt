package com.vaibhav.springjwt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


@EnableConfigurationProperties(RsaKeyProperties::class)
@SpringBootApplication
class SpringSecurityJwtApplication

fun main(args: Array<String>) {
    runApplication<SpringSecurityJwtApplication>(*args)
}
