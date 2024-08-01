// src/Dashboard.js
import React, { useEffect, useState } from 'react';
import { fetchData } from './api';

const Dashboard = () => {
    const [data, setData] = useState(null);
    const [error, setError] = useState('');

    useEffect(() => {
        const getData = async () => {
            try {
                const result = await fetchData('http://127.0.0.1:8080/api/v1/rooms');
                setData(result);
            } catch (error) {
                setError('Failed to fetch data');
            }
        };

        getData();
    }, []);

    if (error) {
        return <p>{error}</p>;
    }

    return (
        <div>
            <h2>Dashboard</h2>
            {data && <pre>{JSON.stringify(data, null, 2)}</pre>}
        </div>
    );
};

export default Dashboard;
