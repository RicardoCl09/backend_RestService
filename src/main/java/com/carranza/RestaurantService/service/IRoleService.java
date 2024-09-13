package com.carranza.RestaurantService.service;

import java.util.List;

import com.carranza.RestaurantService.entities.Role;

public interface IRoleService {

    public void save(Role role);
    public List<Role> findAll();
    public Role findById(Integer id);
    public void deleteById(Integer id);

}
