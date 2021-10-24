package com.example.demo.controllers;

import com.example.demo.entity.Habit;
import com.example.demo.models.HabitRequest;
import com.example.demo.services.HabitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habit")
public class HabitController {
  @Autowired
  HabitService habitService;

  @PostMapping
  public Habit create(@RequestBody HabitRequest habit){
    return habitService.create(habit);
  }
}
