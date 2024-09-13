package com.carranza.RestaurantService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carranza.RestaurantService.entities.Role;
import com.carranza.RestaurantService.repositories.RoleRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void save(Role role) {
        try {
            Role newRole = roleRepository.save(role);
            System.out.println("Role save -> " + newRole.getRoleName());
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        try {
            roleRepository.deleteById(id);
            System.out.println("Role deleted");
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    


}
