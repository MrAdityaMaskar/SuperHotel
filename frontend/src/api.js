// src/api.js
export const fetchData = async (endpoint) => {
    const token = localStorage.getItem('token');
    try {
        const response = await fetch(`${endpoint}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error('Request failed');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Fetch error:', error);
        throw error;
    }
};
