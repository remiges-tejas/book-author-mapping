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