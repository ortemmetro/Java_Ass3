package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usrs")
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(columnDefinition = "TEXT")
  private String firstName;
  private String secondName;
  private String password;
  private String email;
  private Integer age;
  @ManyToMany
  private List<Habit> habits;

  public User(final String firstName, final String secondName, final String email,
              final String password, final Integer age) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.password = password;
    this.age = age;
  }
}
