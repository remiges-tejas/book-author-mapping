// src/AuthorForm.jsx
import React, { useState } from "react";
import axios from "axios";

// Production API URL
const PROD_API_URL = import.meta.env.VITE_PROD_API_URL;

// Local Development API URL
const DEV_API_URL = import.meta.env.VITE_DEV_API_URL;

const AuthorForm = () => {
  const [author, setAuthor] = useState({ name: "", email: "" });
  const [errorMessage, setErrorMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validate input fields
    if (!author.name || !author.email) {
      setErrorMessage("Both name and email are required.");
      return;
    }

    setErrorMessage(""); // Clear previous error messages

    try {
      await axios.post(`${PROD_API_URL}add`, author);
      setSuccessMessage("Author added successfully!");
      setAuthor({ name: "", email: "" }); // Reset input fields
    } catch (error) {
      console.error("Error adding author:", error);
      setErrorMessage("Failed to add author. Please try again.");
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold">Add Author</h2>
      <form onSubmit={handleSubmit} className="flex flex-col">
        <input
          type="text"
          name="name"
          placeholder="Author Name"
          value={author.name}
          onChange={(e) => {
            setAuthor(e.target.value);
          }}
          className="border p-1 rounded mb-2"
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={author.email}
          onChange={(e) => {
            setAuthor(e.target.value);
          }}
          className="border p-1 rounded mb-2"
        />
        {errorMessage && <p className="text-red-500">{errorMessage}</p>}
        {successMessage && <p className="text-green-500">{successMessage}</p>}
        <button type="submit" className="bg-blue-500 text-white p-2 rounded">
          Add Author
        </button>
      </form>
    </div>
  );
};

export default AuthorForm;
