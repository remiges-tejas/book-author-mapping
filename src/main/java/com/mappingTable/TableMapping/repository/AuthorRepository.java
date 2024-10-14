package com.mappingTable.TableMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappingTable.TableMapping.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}