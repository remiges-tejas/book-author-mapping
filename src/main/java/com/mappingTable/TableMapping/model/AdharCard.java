package com.mappingTable.TableMapping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adharcard")
public class AdharCard {

    @Id
    private long id;
    private String authority;



    // One to One Maping to the person Table
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    private Person person;



    // Constructors
    public AdharCard(long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    // getter and setter
    public void setId(long id) {
        this.id = id;
    }
      
    public long getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
