package com.inventforyou.server.controller;

import com.inventforyou.server.dto.LoginRequest;
import com.inventforyou.server.dto.SignupRequest;
import com.inventforyou.server.dto.UserDto;
import com.inventforyou.server.security.JwtAuthenticationResponse;
import com.inventforyou.server.security.JwtTokenProvider;
import com.inventforyou.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public") // Base path pour les utilisateurs publics
public class PublicUserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Autowired // Utiliser Autowired pour l'injection de dépendances
    public PublicUserController(UserService userService,
                                AuthenticationManager authenticationManager,
                                JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        userService.registerNewUserAccount(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        // Logique d'inscription ici...
        // Utilisez userService pour créer un nouvel utilisateur
        return ResponseEntity.ok("Utilisateur enregistré avec succès.");
    }
}
