package com.mappingTable.TableMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappingTable.TableMapping.model.Person;

public interface TableReposititory extends JpaRepository<Person, Long> {

}
