package com.vaibhav.springjwt

import org.springframework.boot.context.properties.ConfigurationProperties
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@ConfigurationProperties(prefix = "rsa")
data class RsaKeyProperties(val publicKey: RSAPublicKey, val privateKey: RSAPrivateKey)