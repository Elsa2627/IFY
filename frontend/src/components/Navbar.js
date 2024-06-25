import React from 'react';
import { Link } from 'react-router-dom';




function Navbar() {
    return (
        <nav>
            <h1>IFY Paris</h1>
            <ul>
                <li><Link to="/">Accueil</Link></li>
                <li><Link to="/cart">Panier</Link></li>
                <li><Link to="/orders">Commandes</Link></li>
                <li><Link to="/favorites">Favoris</Link></li>
            </ul>
        </nav>
    );
}

export default Navbar;
