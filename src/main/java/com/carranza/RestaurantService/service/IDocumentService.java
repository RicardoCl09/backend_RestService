package com.carranza.RestaurantService.service;

import java.util.List;

import com.carranza.RestaurantService.entities.Document;

public interface IDocumentService {
    public void save(Document document);
    public List<Document> findAll();
    public Document findById(Integer id);
    public void delete(Integer id);
}
