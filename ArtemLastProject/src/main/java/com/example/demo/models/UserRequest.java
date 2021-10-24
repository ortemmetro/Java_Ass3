package com.example.demo.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {
  private Long id;
  private String email;
  private String password;
  private String firstName;
  private String secondName;
  private Integer age;

}
