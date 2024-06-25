document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('loginFormModal').onsubmit = function(event) {
        event.preventDefault();
        // Logique de connexion
        const username = document.getElementById('usernameModal').value;
        const password = document.getElementById('passwordModal').value;

        fetch('/api/public/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username: username, password: password }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('The login failed');
                }
                return response.json();
            })
            .then(data => {
                console.log('Login successful:', data);
                // Vous pouvez rediriger l'utilisateur ou stocker le token JWT ici
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };


    document.getElementById('signup-form').onsubmit = function(event) {
        event.preventDefault();
        // Logique d'inscription
        const username = document.getElementById('signup-username').value;
        const password = document.getElementById('signup-password').value;
        const email = document.getElementById('signup-email').value;

        fetch('/api/public/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username: username, password: password, email: email }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Registration failed');
                }
                return response.json();
            })
            .then(data => {
                console.log('Registration successful:', data);
                // Vous pouvez informer l'utilisateur de la réussite de l'inscription ici
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };



});
