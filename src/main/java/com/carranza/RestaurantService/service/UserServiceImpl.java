package com.carranza.RestaurantService.service;

import java.util.*;
import java.time.*;
import java.time.format.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carranza.RestaurantService.entities.Document;
import com.carranza.RestaurantService.entities.Role;
import com.carranza.RestaurantService.entities.Schedule;
import com.carranza.RestaurantService.entities.User;
import com.carranza.RestaurantService.repositories.DocumentRepository;
import com.carranza.RestaurantService.repositories.RoleRepository;
import com.carranza.RestaurantService.repositories.ScheduleRepository;
import com.carranza.RestaurantService.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private ScheduleRepository scheduleRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    @Transactional
    public void save(User user, Integer roleId, Integer scheduleId, Integer documentId) {
        LocalDate actualDate = getDate();
        Date parsedDate = Date.from(actualDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        try {
            Optional<User> userOpt = userRepository.findById(user.getIdUser());
            if (userOpt.isPresent()) {
                Optional<Role> roleOpt = roleRepository.findById(roleId);
                Optional<Schedule> scheduleOpt = scheduleRepository.findById(scheduleId);
                Optional<Document> documentOpt = documentRepository.findById(documentId);
                User newUser = userOpt.get();
                newUser.setRole(roleOpt.get());
                newUser.setSchedule(scheduleOpt.get());
                newUser.setDocument(documentOpt.get());
                newUser.setUpdatedAt(parsedDate);
                userRepository.save(newUser);
            } else {
                Optional<Role> roleOpt = roleRepository.findById(roleId);
                Optional<Schedule> scheduleOpt = scheduleRepository.findById(scheduleId);
                Optional<Document> documentOpt = documentRepository.findById(documentId);
                User newUser = new User(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), documentOpt.get(), user.getNroDocument(), roleOpt.get(), scheduleOpt.get(), 1, "admin", parsedDate, null, null);
                userRepository.save(newUser);
            }
            System.out.println("User saved succesfully.");
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
            System.out.println("User deleted");
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    LocalDate getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedDate = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(formatedDate, formatter);
        return parsedDate;
    }

}
