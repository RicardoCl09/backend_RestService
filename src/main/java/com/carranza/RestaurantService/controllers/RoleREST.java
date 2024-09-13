package com.carranza.RestaurantService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carranza.RestaurantService.entities.Role;
import com.carranza.RestaurantService.service.IRoleService;

@RestController
@RequestMapping("restaurantservice")
public class RoleREST {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role getRoleById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @PostMapping("/saveRole")
    public void saveRole(@RequestBody Role role) {
        roleService.save(role);
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteById(id);
    }

}
