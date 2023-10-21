package com.vaibhav.springjwt

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val tokenService: TokenService) {

    val LOG: Logger= LoggerFactory.getLogger(AuthController::class.java)

    @PostMapping("/token")
    fun getToken(authentication: Authentication): String{
        val token = tokenService.generateToken(authentication)
        LOG.debug("token: {}", token)
        return token
    }

}