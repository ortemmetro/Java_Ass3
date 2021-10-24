package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.models.HabitRequest;

@Entity
@Table(name = "habits")
@Data
@NoArgsConstructor
public class Habit {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String type;
  private String goal;
  private Date start_date;
  private Date end_date;

  public Habit(HabitRequest habitRequest) {
    this.name = habitRequest.getName();
    this.type = habitRequest.getType();
    this.goal = habitRequest.getGoal();
    this.start_date = habitRequest.getStart_date();
    this.end_date = habitRequest.getEnd_date();
  }
}
