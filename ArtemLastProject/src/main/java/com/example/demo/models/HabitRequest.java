package com.example.demo.models;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class HabitRequest {
  private String id;
  private String name;
  private String type;
  private String goal;
  private Date start_date;
  private Date end_date;
}
