// src/App.jsx
import React from 'react';
import AuthorList from './components/AuthorList';
import AuthorForm from './components/AuthorForm'; // Import the new component
import './index.css'; // Ensure Tailwind is applied

function App() {
    return (
        <div className="App">
            <h1 className="text-3xl font-bold text-center my-4 text-teal-600">Authors and Books</h1>
            <AuthorForm /> {/* Add the AuthorForm component */}
            <AuthorList />
        </div>
    );
}

export default App;