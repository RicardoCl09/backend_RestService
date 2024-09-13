package com.carranza.RestaurantService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carranza.RestaurantService.entities.User;
import com.carranza.RestaurantService.service.IUserService;


@RestController
@RequestMapping("restaurantservice")
public class UserREST {

    @Autowired
    private IUserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user, @RequestParam Integer rolId, @RequestParam Integer scheduleId, @RequestParam Integer documentId) {
        userService.save(user, scheduleId, scheduleId, documentId);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}
