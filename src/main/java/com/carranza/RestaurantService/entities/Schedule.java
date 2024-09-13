package com.carranza.RestaurantService.entities;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule implements Serializable{
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idSchedule;

    @Column(name = "startHour", nullable = false)
    public String startHour;

    @Column(name = "endHour", nullable = false)
    public String endHour;

    // Relaciones
    @OneToMany(mappedBy = "schedules")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Schedule() {

    }

    public Schedule(String startHour, String endHour, Set<User> users) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.users = users;
    }

    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    
    
}
