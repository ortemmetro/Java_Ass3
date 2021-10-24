package com.example.demo.services;

import java.util.Date;

import com.example.demo.entity.Habit;
import com.example.demo.models.HabitRequest;
import com.example.demo.respository.HabitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

  @Autowired
  HabitRepository habitRepository;

  public Habit create(HabitRequest request) {
    request.setStart_date(new Date());
    return habitRepository.save(new Habit(request));
  }
}
