package com.carranza.RestaurantService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carranza.RestaurantService.entities.Document;
import com.carranza.RestaurantService.service.IDocumentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("restaurantservice")
public class DocumentREST {

    @Autowired
    private IDocumentService documentService;


    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return documentService.findAll();
    }
    
    @PostMapping("/savedocument")
    public void saveDocument(@RequestBody Document document) {
        documentService.save(document);
    }

    @DeleteMapping("deleteDocument/{id}")
    public void deleteDocument(@PathVariable Integer id) {
        documentService.delete(id);
    }

}
