package com.carranza.RestaurantService.service;

import java.util.List;

import com.carranza.RestaurantService.entities.Schedule;

public interface IScheduleService {
    public void save(Schedule schedule);
    public List<Schedule> findAll();
    public Schedule findById(Integer id);
    public void deleteById(Integer id);
}
