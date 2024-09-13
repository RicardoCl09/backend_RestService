package com.carranza.RestaurantService.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carranza.RestaurantService.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
