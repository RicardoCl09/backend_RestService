package com.carranza.RestaurantService.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carranza.RestaurantService.entities.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer> {

}
