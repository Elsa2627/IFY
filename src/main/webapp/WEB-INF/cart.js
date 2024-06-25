document.addEventListener('DOMContentLoaded', () => {
    displayCartItems();
    document.getElementById('checkoutBtn').addEventListener('click', () => {
        alert('Procéder au paiement...');
        // Ici, vous pouvez ajouter la logique pour rediriger l'utilisateur vers la page de paiement ou afficher un formulaire de paiement.
    });
});



// Les fonctions removeItemFromCart et updateItemQuantity restent inchangées

function displayCartItems() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const cartContainer = document.getElementById('cart-items-container');
    cartContainer.innerHTML = '';
    cart.forEach(item => {
        cartContainer.innerHTML += `<div>${item.name} - Quantité: ${item.quantity} - Prix: €${item.price}</div>`;
    });
}

document.addEventListener('DOMContentLoaded', displayCartItems);


function removeItemFromCart(itemId) {
    const cart = JSON.parse(localStorage.getItem('cart')) || {};
    delete cart[itemId];
    localStorage.setItem('cart', JSON.stringify(cart));
    displayCartItems(); // Rafraîchir l'affichage
}

function updateItemQuantity(itemId, newQuantity) {
    if (newQuantity < 1) return; // Éviter les quantités négatives ou nulles
    const cart = JSON.parse(localStorage.getItem('cart')) || {};
    cart[itemId] = newQuantity;
    localStorage.setItem('cart', JSON.stringify(cart));
    displayCartItems(); // Rafraîchir l'affichage
}

window.onload = function() {
    let panier = localStorage.getItem('panier') ? JSON.parse(localStorage.getItem('panier')) : [];
    let listePanier = document.getElementById('listePanier');
    panier.forEach(article => {
        let li = document.createElement('li');
        li.textContent = article;
        listePanier.appendChild(li);
    });
}
