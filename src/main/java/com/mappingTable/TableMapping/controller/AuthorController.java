package com.mappingTable.TableMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mappingTable.TableMapping.DTO.AuthorDTO;
import com.mappingTable.TableMapping.DTO.BookDTO;
import com.mappingTable.TableMapping.model.Author;
import com.mappingTable.TableMapping.service.AuthorService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
            

        
    // Endpoint to fetch all authors
  @GetMapping("/")
  public List<AuthorDTO> getAllAuthors() {
      return authorService.getAllAuthors();
  }

    // Endpoint to add an author
    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

   






    

}