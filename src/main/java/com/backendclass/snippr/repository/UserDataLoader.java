package com.backendclass.snippr.repository;

import com.backendclass.snippr.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user = new User("spartanginger@gmail.com","hashed!");
            User user1 = new User("bob@gmail.com","hashed!");
            userRepository.save(user);
            userRepository.save(user1);
        }
        System.out.println("User table seeded! new user count is: " + userRepository.count());
    }
}
