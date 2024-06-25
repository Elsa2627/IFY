package com.inventforyou.server.controller;

import com.inventforyou.server.service.BagService;
import com.inventforyou.server.entity.Bag; // Assurez-vous que le chemin du package est correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bags") // Base path pour les sacs
@CrossOrigin(origins = "http://localhost:3000") // Autorise l'accès depuis le front-end
public class BagController {

    private final BagService bagService;

    @Autowired // Utiliser Autowired pour l'injection de dépendances
    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    // Définissez un endpoint pour obtenir tous les sacs
    @GetMapping("/")
    public ResponseEntity<List<Bag>> getAllBags() {
        List<Bag> bags = bagService.getAllBags();
        return ResponseEntity.ok(bags);
    }

    // ... autres méthodes pour CRUD sur les sacs
}

