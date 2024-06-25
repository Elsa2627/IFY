import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Product from '../components/Product';

function Home() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/products')
            .then(response => setProducts(response.data))
            .catch(error => console.error('Erreur lors de la récupération des produits', error));
    }, []);

    return (
        <div>
            <h1>Produits Disponibles</h1>
            <div className="product-grid">
                {products.map(product => (
                    <Product key={product.id} product={product} />
                ))}
            </div>
        </div>
    );
}

export default Home;

