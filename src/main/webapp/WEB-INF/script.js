document.addEventListener('DOMContentLoaded', () => {
    initializeCart();
    setupAddToCartButtons();
    setupSearch();
});


function addToCart(product) {
    console.log("Attempting to add product:", product);
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    console.log("Current cart:", cart);
    let existingProduct = cart.find(p => p.id === product.id);
    if (existingProduct) {
        existingProduct.quantity += 1;
    } else {
        product.quantity = 1;
        cart.push(product);
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    console.log('Updated cart:', cart);
    alert("Article ajouté au panier!");
    updateCartDisplay();
}

function setupAddToCartButtons() {
    document.querySelectorAll('.add-to-cart-btn').forEach(button => {
        button.addEventListener('click', function() {
            const product = {
                id: this.dataset.id,
                name: this.dataset.name,
                price: parseFloat(this.dataset.price)
            };
            addToCart(product);
        });
    });
}


function initializeCart() {
    localStorage.getItem('cart') || localStorage.setItem('cart', JSON.stringify([]));
    updateCartDisplay();
}

function updateCartDisplay() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const totalQuantity = cart.reduce((total, product) => total + product.quantity, 0);
    const cartCountElement = document.getElementById('cart-count');
    cartCountElement ? cartCountElement.textContent = totalQuantity :
        console.warn("Element 'cart-count' not found. Cart display cannot be updated on this page.");
}

function setupSearch() {
    const searchButton = document.getElementById('searchBtn');
    const searchQueryInput = document.getElementById('searchQuery');
    if (searchButton) {
        searchButton.addEventListener('click', () => performSearch(searchQueryInput.value.trim().toLowerCase()));
    } else {
        console.warn("'searchBtn' does not exist on this page.");
    }
}

function performSearch(query) {
    document.querySelectorAll('.item').forEach(item => {
        const title = item.querySelector('h2').textContent.toLowerCase();
        item.style.display = title.includes(query) ? '' : 'none';
    });
}
