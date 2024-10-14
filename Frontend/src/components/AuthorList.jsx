// src/AuthorList.jsx
import React, { useEffect, useState } from "react";
import axios from "axios";

// Production API URL
const PROD_API_URL = import.meta.env.VITE_PROD_API_URL;

// Local Development API URL
const DEV_API_URL = import.meta.env.VITE_DEV_API_URL;

const AuthorList = () => {
  const [authors, setAuthors] = useState([]);
  const [newBook, setNewBook] = useState({ title: "", genre: "" });

  useEffect(() => {
    const fetchAuthors = async () => {
      try {
        const response = await axios.get(PROD_API_URL);
        setAuthors(response.data);
      } catch (error) {
        console.error("Error fetching authors:", error);
      }
    };

    fetchAuthors();
  }, []);

  const handleAddBook = async (authorId) => {
    // Validate input fields
    if (!newBook.title || !newBook.genre) {
      alert("Both title and genre are required.");
      return; // Exit the function if validation fails
    }

    try {
      await axios.post(
        `http://localhost:8080/api/v1/authors/${authorId}/books`,
        newBook
      );
      setNewBook({ title: "", genre: "" }); // Reset input fields

      // Re-fetch authors to update the list
      const response = await axios.get(PROD_API_URL);
      setAuthors(response.data);
    } catch (error) {
      console.error("Error adding book:", error);
    }
  };
  return (
    <div className="p-4">
      <h2 className="text-xl font-bold">Authors</h2>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {authors.map((author) => (
          <div key={author.id} className="border p-4 rounded shadow">
            <h3 className="font-semibold">{author.name}</h3>
            <p>Email: {author.email}</p>
            <h4>Books:</h4>
            <ul>
              {author.books.map((book) => (
                <li key={book.id}>
                  <strong>{book.title}</strong> - {book.genre}
                </li>
              ))}
            </ul>
            <input
              required
              type="text"
              placeholder="Book Title"
              value={newBook.title}
              onChange={(e) =>
                setNewBook({ ...newBook, title: e.target.value })
              }
              className="border p-1 rounded w-full mt-2"
            />
            <input
              required
              type="text"
              placeholder="Genre"
              value={newBook.genre}
              onChange={(e) =>
                setNewBook({ ...newBook, genre: e.target.value })
              }
              className="border p-1 rounded w-full mt-2"
            />
            <button
              onClick={() => handleAddBook(author.id)}
              className="bg-blue-500 text-white p-2 rounded mt-2"
            >
              Add Book
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AuthorList;
