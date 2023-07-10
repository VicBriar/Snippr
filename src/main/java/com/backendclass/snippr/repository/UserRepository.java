package com.backendclass.snippr.repository;

import com.backendclass.snippr.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
