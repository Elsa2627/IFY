package com.inventforyou.server.service;

import com.inventforyou.server.entity.Cart;
import com.inventforyou.server.entity.Product;
import com.inventforyou.server.repository.CartRepository;
import com.inventforyou.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void addProductToCart(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));

        Cart cart = getCartForCurrentUser(); // Assurez-vous que cette méthode est bien implémentée
        cart.getProducts().add(product);

        cartRepository.save(cart);
    }

    private Cart getCartForCurrentUser() {
        // Logique pour obtenir le panier de l'utilisateur actuel
        // Cela peut impliquer de récupérer l'utilisateur actuel via un service d'authentification
        // et de rechercher le panier correspondant dans la base de données
        Long currentUserId = getCurrentUserId(); // Cette méthode devrait obtenir l'ID de l'utilisateur connecté
        return cartRepository.findByUserId(currentUserId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUserId(currentUserId);
                    return cartRepository.save(newCart);
                });
    }

    private Long getCurrentUserId() {
        // Logique pour obtenir l'ID de l'utilisateur actuellement connecté
        // Cela peut varier en fonction de votre configuration de sécurité
        return 1L; // Par exemple, renvoie l'ID de l'utilisateur 1 pour des tests
    }
}
