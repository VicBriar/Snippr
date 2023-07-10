package com.backendclass.snippr.models;

import jakarta.persistence.*;

import java.util.Set;

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

}