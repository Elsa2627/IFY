package com.inventforyou.server.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ici, vous devriez interroger votre base de données H2 pour charger les informations de l'utilisateur.
        // Si l'utilisateur n'est pas trouvé, lancez une UsernameNotFoundException.
        // Sinon, renvoyez une instance de User de Spring Security avec les rôles et autorités.

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
