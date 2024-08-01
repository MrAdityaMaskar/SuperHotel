// src/Login.js
import React, { useState } from 'react';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://127.0.0.1:8080/api/v1/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            if (!response.ok) {
                throw new Error('Login failed');
            }

            const data = await response.json();
            localStorage.setItem('token', data.accessToken);
            // Redirect or handle successful login
        } catch (error) {
            setError('Login failed. Please check your credentials.');
        }
    };

    const handleLogout = async(e) =>{
        e.preventDefault();
        localStorage.removeItem('token');
        try{
            const response = await fetch('http://127.0.0.1:8080/logout', { 
                method: 'POST',
                headers:{
                    'Content-Type': 'applicaiton/json',
                }

            });
        }
        catch(error){
            setError('Logout Failed !!');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Username</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div>
                    <label>Password</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                {error && <p>{error}</p>}
                <button type="submit">Login</button>
            </form>
            <button type="submit" onClick={handleLogout}>logout</button>
        </div>

    );

};

export default Login;
