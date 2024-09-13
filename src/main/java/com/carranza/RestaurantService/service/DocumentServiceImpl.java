package com.carranza.RestaurantService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carranza.RestaurantService.entities.Document;
import com.carranza.RestaurantService.repositories.DocumentRepository;

import jakarta.transaction.Transactional;

@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    @Transactional
    public void save(Document document) {
        try {
            Document newDocument = documentRepository.save(document);
            System.out.println("Document saved -> " + newDocument.getIdDocument());
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Document> findAll() {
        return (List<Document>) documentRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            documentRepository.deleteById(id);
            System.out.println("Document deleted.");
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Document findById(Integer id) {
        return documentRepository.findById(id).orElse(null);
    }

}
