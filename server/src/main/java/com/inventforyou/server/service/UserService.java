package com.inventforyou.server.service;

import com.inventforyou.server.dto.SignupRequest;
import com.inventforyou.server.entity.User; // Assurez-vous que c'est le bon import pour votre entité User
import com.inventforyou.server.repository.UserRepository;
import com.inventforyou.server.dto.UserDto; // Créez cette classe de transfert de données (DTO)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {



    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Utilisez l'injection de dépendances via le constructeur au lieu des champs
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUserAccount(UserDto accountDto) {
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setEmail(accountDto.getEmail());
        user.setPhone(accountDto.getPhone());
        user.setAddress(accountDto.getAddress());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return userRepository.save(user);
    }



    public User registerNewUserAccount(SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Il existe déjà un utilisateur avec ce nom d'utilisateur: " + signupRequest.getUsername());
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        // Ajoutez plus de champs en fonction de la classe User

        return userRepository.save(user);

    }

    public class UserAlreadyExistException extends RuntimeException {
        public UserAlreadyExistException(String message) {
            super(message);
        }
    }





}