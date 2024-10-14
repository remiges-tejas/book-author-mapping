package com.mappingTable.TableMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappingTable.TableMapping.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}