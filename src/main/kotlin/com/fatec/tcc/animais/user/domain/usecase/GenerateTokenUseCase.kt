package com.fatec.tcc.animais.user.domain.usecase

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit

@Component
class GenerateTokenUseCase(
    private val jwtEncoder: JwtEncoder
) {
    operator fun invoke(userDetails: UserDetails, id: Long): String {
        val now = Instant.now()
        val scope = userDetails.authorities.joinToString(" ", transform = GrantedAuthority::getAuthority)

        val claims = JwtClaimsSet.builder()
            .id(id.toString())
            .issuer(userDetails.username)
            .subject(userDetails.username)
            .issuedAt(now)
            .expiresAt(now.plus(24, ChronoUnit.HOURS))
            .claim("scope", scope)
            .build()

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }
}