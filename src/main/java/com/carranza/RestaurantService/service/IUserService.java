package com.carranza.RestaurantService.service;

import java.util.List;

import com.carranza.RestaurantService.entities.User;

public interface IUserService {

    public void save(User user, Integer roleId, Integer scheduleId, Integer documentId);
    public List<User> findAll();
    public User findById(Integer id);
    public void deleteById(Integer id);

}
