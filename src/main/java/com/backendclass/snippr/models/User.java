package com.backendclass.snippr.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @OneToMany(fetch = FetchType.LAZY)
  private Set<Snippet> snippets;
  public User () {}
  public User (String email, String password) {
    this.email = email;
    this.password = password;
  }
}