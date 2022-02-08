package com.lorenjamison.citronella.api.authentication

import groovy.transform.CompileStatic
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@CompileStatic
@Component
class TokenManager implements Serializable {
    public static final long serialVersionUID = 2246391566253625425L
    public static final long TOKEN_VALIDITY_SECONDS = 12 * 60 * 60  //12 hours

    @Value('${jwt.secret}')
    private String jwtSecret

    String generateJwtToken(UserDetails userDetails) {
        Map<String, Object> claims = [:]
        Long currentTimestamp = System.currentTimeMillis()
        Long expirationTimestamp = currentTimestamp + (TOKEN_VALIDITY_SECONDS * 1000)
        Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.username)
                .setIssuedAt(new Date(currentTimestamp))
                .setExpiration(new Date(expirationTimestamp))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }

    Boolean validateJwtToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token)
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .body
        Boolean isTokenExpired = claims.getExpiration().before(new Date())

        (username == userDetails.username && !isTokenExpired)
    }

    String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body
        claims.getSubject()
    }
}
