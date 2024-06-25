package com.inventforyou.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Définissez le bean pour le SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Désactive CSRF pour les appels API (nécessaire si vous utilisez des jetons JWT)
                .authorizeRequests(authz -> authz
                        .dispatcherTypeMatchers(HttpMethod.valueOf("/api/public/**")).permitAll() // Autoriser l'accès sans authentification
                        .anyRequest().authenticated()) // Toutes les autres requêtes nécessitent une authentification
                .formLogin(form -> form
                        .loginPage("/login") // Spécifiez votre propre page de connexion si vous en avez une
                        .permitAll())
                .logout(LogoutConfigurer::permitAll);

        // Ajoutez d'autres configurations si nécessaire

        return http.build();
    }

    // Bean pour encoder le mot de passe


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    // Définir d'autres beans et configurations si nécessaire
}
