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

import com.carranza.RestaurantService.entities.Schedule;
import com.carranza.RestaurantService.service.IScheduleService;

@RestController
@RequestMapping("restaurantservice")
public class ScheduleRest {

    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    @GetMapping("/schedules/{id}")
    public Schedule getScheduleById(@PathVariable Integer id) {
        return scheduleService.findById(id);
    }

    @PostMapping("/saveSchedule")
    public void saveSchedule(@RequestBody Schedule schedule) {
        scheduleService.save(schedule);
    }

    @DeleteMapping("/deleteSchedule")
    public void deleteSchedule(Integer id) {
        scheduleService.deleteById(id);
    }

}
