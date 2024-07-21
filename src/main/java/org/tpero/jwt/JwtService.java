package org.tpero.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tpero.login.JwtConfigProperties;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtConfigProperties jwtConfigProperties;

    /**
     * Build and return a JWT
     * @param subject The subject of the token
     * @return The JWT
     */
    public String buildToken(final String subject) {
        final var currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(
                        currentTime + this.jwtConfigProperties.expiration().ms()
                )).signWith(Keys.hmacShaKeyFor(this.jwtConfigProperties.secret().getBytes()))
                .compact();
    }

    public Jws<Claims> decode(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(this.jwtConfigProperties.secret().getBytes()))
                .build()
                .parseClaimsJws(token);
    }
}
