package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Habit;
import com.example.demo.entity.User;
import com.example.demo.helpers.ValidateHelper;
import com.example.demo.models.UserRequest;
import com.example.demo.respository.HabitRepository;
import com.example.demo.respository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private HabitRepository habitRepository;

  public boolean saveUser(UserRequest userRequest) {
    if(!ValidateHelper.validate(userRequest.getEmail())) {
      return false;
    }
    User byEmail = userRepository.findByEmail(userRequest.getEmail());
    if(byEmail != null) {
      return false;
    }
    User user = new User(userRequest.getFirstName(), userRequest.getSecondName(),
            userRequest.getEmail(), userRequest.getPassword(), userRequest.getAge());
    userRepository.save(user);
    return true;
  }

  public boolean addHabitsToUser(Integer userId, List<Integer> habitsIds) {
    Optional<User> userOptional = userRepository.findById(userId.longValue());
    User user = userOptional.orElse(null);
    if(user == null) {
      return false;
    }
    List<Habit> habits = new ArrayList<>();
    habitsIds.forEach(id -> habitRepository.findById(id.longValue()).ifPresent(p -> habits.add(p)));
    user.setHabits(habits);
    userRepository.save(user);
    return true;
  }

  public User getUser(Integer id) {
    return userRepository.findById(id.longValue()).orElse(null);
  }

}
