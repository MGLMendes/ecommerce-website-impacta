package br.com.impactaproject.ecommerce.controller;

import br.com.impactaproject.ecommerce.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 20)
public class AuthController {

    private final JwtUtils jwtUtils;


    @GetMapping("/check-token/{token}")
    public Boolean validateToken(@PathVariable String token) {
        return jwtUtils.tokenValido(token);
    }
}
