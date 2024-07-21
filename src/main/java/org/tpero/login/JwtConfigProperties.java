package org.tpero.login;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("jwt")
public record JwtConfigProperties(
        @DefaultValue Expiration expiration,
        String secret
) {
    public record Expiration(
            @DefaultValue("15000") long ms
    ) {
    }
}
