import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Cart from './pages/Cart';
import Orders from './pages/Orders';
import Favorites from './pages/Favorites';
import Navbar from './components/Navbar';


function App() {
    return (
        <Router>
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <p>
                        Edit <code>src/App.js</code> and save to reload.
                    </p>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Learn React
                    </a>
                </header>
                <Navbar />
                <Routes>
                    <Route path="/" exact component={Home} />
                    <Route path="/cart" component={Cart} />
                    <Route path="/orders" component={Orders} />
                    <Route path="/favorites" component={Favorites} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
