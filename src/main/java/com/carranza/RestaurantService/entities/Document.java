package com.carranza.RestaurantService.entities;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocument;

    @Column(name = "documentName", nullable = false)
    private String documentName;

    @Column(name = "maxChars", nullable = false)
    private int maxChars;

    @Column(name = "minChars", nullable = false)
    private int minChars;

    // Relaciones
    @OneToMany(mappedBy = "documents")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Document() {

    }

    public Document(String documentName, int maxChars, int minChars, Set<User> users) {
        this.documentName = documentName;
        this.maxChars = maxChars;
        this.minChars = minChars;
        this.users = users;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public int getMaxChars() {
        return maxChars;
    }

    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    public int getMinChars() {
        return minChars;
    }

    public void setMinChars(int minChars) {
        this.minChars = minChars;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    
    
    
}
