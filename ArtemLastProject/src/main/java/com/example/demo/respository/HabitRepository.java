package com.example.demo.respository;

import com.example.demo.entity.Habit;

import org.springframework.data.repository.CrudRepository;

public interface HabitRepository extends CrudRepository<Habit, Long> {

}
