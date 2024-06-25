// Ce code est destiné à être exécuté une fois que le DOM est entièrement chargé.
document.addEventListener('DOMContentLoaded', () => {
    // Ajout de l'écouteur d'événements au bouton d'ajout au panier
    const addToCartButton = document.getElementById('addToCartButton');
    if (addToCartButton) {
        addToCartButton.addEventListener('click', function () {
            console.log('Le bouton a été cliqué');
            // Remplacer '1' par l'ID réel du produit à ajouter
            addToCart({id: "1", name: "Produit", price: "19.99", quantity: 1});
        });
    }

    // Mettre à jour l'affichage du panier au chargement de la page
    updateCartDisplay();

    // Remplacer par l'URL correcte de votre API
    fetch('http://localhost:63342/api/user/orders')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erreur réseau');
            }
            return response.json();
        })
        .then(orders => {
            displayOrders(orders);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des commandes:', error);
            displayOrders(fallbackOrders);
        });
});

document.addEventListener('DOMContentLoaded', function() {
    setupAddToCartButtons();
});

function setupAddToCartButtons() {
    document.querySelectorAll('.add-to-cart-btn').forEach(button => {
        button.addEventListener('click', function() {
            const product = {
                id: this.dataset.id,
                name: this.dataset.name,
                price: parseFloat(this.dataset.price),
                quantity: 1
            };
            addToCart(product);
        });
    });
}


// Fonction pour afficher les commandes
function displayOrders(orders) {
    const ordersContainer = document.getElementById('ordersContainer');
    if (!ordersContainer) {
        console.error("L'élément ordersContainer n'existe pas dans le DOM");
        return;
    }

    ordersContainer.innerHTML = ''; // Clear existing orders
    orders.forEach(order => {
        const orderElement = document.createElement('div');
        orderElement.classList.add('order-item');
        orderElement.innerHTML = `
            <h2>Commande #${order.id}</h2>
            <p>Article: ${order.article}</p>
            <p>Quantité: ${order.quantite}</p>
            <p>Prix: ${order.prix}</p>
            <p>Date: ${new Date(order.date).toLocaleDateString()}</p>
        `;
        ordersContainer.appendChild(orderElement);
    });
}

function addToCart(product) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let productExists = cart.find(p => p.id === product.id);
    if (productExists) {
        productExists.quantity += 1;
    } else {
        product.quantity = 1;
        cart.push(product);
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    console.log("Cart updated:", cart);
    alert("Produit ajouté au panier !");
}


// Fonction pour mettre à jour l'affichage du panier
function updateCartDisplay() {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let totalQuantity = 0;
    for (let item of cart) {
        totalQuantity += item.quantity;
    }

    const cartQuantity = document.getElementById('cartQuantity');
    if (!cartQuantity) {
        console.error("L'élément cartQuantity n'existe pas dans le DOM");
        return;
    }

    cartQuantity.textContent = totalQuantity;
}





