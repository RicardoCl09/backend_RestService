package com.carranza.RestaurantService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carranza.RestaurantService.entities.Schedule;
import com.carranza.RestaurantService.repositories.ScheduleRepository;

import jakarta.transaction.Transactional;

@Service
public class ScheduleServiceImpl implements IScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public List<Schedule> findAll() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        try {
            scheduleRepository.deleteById(null);
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void save(Schedule schedule) {
        try {
            Schedule scheduleToSave = new Schedule();
            Optional<Schedule> scheduleOpt = scheduleRepository.findById(schedule.getIdSchedule());
            if (scheduleOpt.isPresent()) {
                scheduleToSave = scheduleOpt.get();
                scheduleToSave.setStartHour(schedule.getStartHour());
                scheduleToSave.setEndHour(schedule.getEndHour());
            } else {
                scheduleToSave = schedule;  
            }
            scheduleRepository.save(scheduleToSave);
            System.out.println("Schedule saved succesfully.");
            
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Schedule findById(Integer id) {
        return scheduleRepository.findById(id).orElse(null);
    }

}
