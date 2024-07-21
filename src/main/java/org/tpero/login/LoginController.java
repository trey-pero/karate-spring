package org.tpero.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tpero.jwt.JwtService;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody final LoginRequest loginRequest) {
        // No real login, just build a JWT from the login request
        // to focus on a simple example of integrating Spring with Karate
        return this.jwtService.buildToken(loginRequest.username());
    }
}
