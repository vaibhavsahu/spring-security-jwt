package com.vaibhav.springjwt

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService(private val jwtEncoder: JwtEncoder) {

    fun generateToken(authentication: Authentication):String{
        val now = Instant.now()
        val scope = authentication.authorities.map { GrantedAuthority::getAuthority }
            .joinToString(separator = " ")
        val jwtClaims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(1, ChronoUnit.HOURS))
            .subject(authentication.name).claim("scope", scope).build()

        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaims)).tokenValue

    }
}