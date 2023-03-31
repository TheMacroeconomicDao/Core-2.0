package gyber.org.mainCore.controllers;

import gyber.org.mainCore.configs.security.auth.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticateEmail")
    public ResponseEntity<AuthenticationResponse> authenticateEmail(
            @RequestBody AuthenticationRequestEmail request
    ) {
        return ResponseEntity.ok(service.authenticateEmail(request));
    }



}
