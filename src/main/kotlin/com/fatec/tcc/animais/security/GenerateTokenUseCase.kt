package com.fatec.tcc.animais.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class GenerateTokenUseCase(
    private val jwtEncoder: JwtEncoder
) {
    operator fun invoke(userDetails: UserDetails): String {
        val now = Instant.now()
        val expiry = 3600L
        val scope = userDetails.authorities.joinToString(" ", transform = GrantedAuthority::getAuthority)

        val claims = JwtClaimsSet.builder()
            .issuer(userDetails.username)
            .subject(userDetails.username)
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .claim("scope", scope)
            .build()

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }
}