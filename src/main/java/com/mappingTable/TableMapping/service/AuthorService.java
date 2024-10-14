package com.mappingTable.TableMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mappingTable.TableMapping.DTO.AuthorDTO;
import com.mappingTable.TableMapping.DTO.BookDTO;
import com.mappingTable.TableMapping.model.Author;
import com.mappingTable.TableMapping.model.Book;
import com.mappingTable.TableMapping.repository.AuthorRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Author saveAuthor(Author author) {
        if (author.getBooks() != null) {
            for (Book book : author.getBooks()) {
                book.setAuthor(author); // Set back-reference to avoid circular reference issues
            }
        }
        return authorRepository.save(author);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::mapAuthorToDTO)
                .toList();
    }

    public Book addBookToAuthor(Long authorId, BookDTO bookDTO) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setAuthor(author); // Set the back-reference
    
        // Save the new book (assuming you have a BookRepository)
        // If you don't have a BookRepository, you can save it directly in the Author entity.
        
        // Assuming you have a BookRepository
        // bookRepository.save(book); // Uncomment this if you have a separate repository for books
    
        // Alternatively, add the book to the author's list and save the author
        author.getBooks().add(book); // Add the book to the author's list of books
        authorRepository.save(author); // Save the author to persist changes
    
        return book; // Return the newly created book
    }
    private AuthorDTO mapAuthorToDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        dto.setBooks(author.getBooks().stream()
                .map(this::mapBookToDTO)
                .toList());
        return dto;
    }

    private BookDTO mapBookToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setGenre(book.getGenre());
        return bookDTO;
    }
}