import axios from 'axios';



const API_URL = 'http://localhost:8080/api/cart';

export const addProductToCart = async (productId, userId) => {
    return axios.post(`${API_URL}/add/${productId}`, { userId });
};

const cartService = {
    addProductToCart
};

export default cartService;
