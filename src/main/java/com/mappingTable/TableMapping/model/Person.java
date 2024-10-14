package com.mappingTable.TableMapping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private long id;
    private String name;
    private int age;



   // One to One Maping to The AdharCard Table
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="adhar_id")
   private AdharCard adharCard;




    // Constructors
    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    // getter and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
