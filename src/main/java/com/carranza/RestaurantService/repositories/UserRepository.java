package com.carranza.RestaurantService.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carranza.RestaurantService.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
}
