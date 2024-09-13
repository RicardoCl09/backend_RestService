package com.carranza.RestaurantService.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carranza.RestaurantService.entities.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer>{

}
