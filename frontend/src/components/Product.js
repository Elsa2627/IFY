import React from 'react';
import cartService from '../services/cartService';


function Product({ product }) {
    const handleAddToCart = async () => {
        try {
            await cartService.addProductToCart(product.id);
            alert('Produit ajouté au panier avec succès !');
        } catch (error) {
            alert('Erreur lors de l\'ajout au panier.');
        }
    };

    return (
        <div>
            <h3>{product.name}</h3>
            <p>Prix : €{product.price}</p>
            <button onClick={handleAddToCart}>Ajouter au Panier</button>
        </div>
    );
}

export default Product;

