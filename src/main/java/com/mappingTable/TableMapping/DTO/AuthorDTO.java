package com.mappingTable.TableMapping.DTO;

import java.util.List;

public class AuthorDTO {

    // defing the instace variable

    private Long id;
    private String name;
    private String email;
    private List<BookDTO> books;

    // Getter and Setter
    public Long getId() {   
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

}
