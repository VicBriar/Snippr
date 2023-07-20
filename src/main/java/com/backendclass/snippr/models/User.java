package com.backendclass.snippr.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY)
  private Set<Snippet> snippets;
  public User () {}
  public User (String email, String password) {
    this.email = email;
    this.password = password;
  }
}