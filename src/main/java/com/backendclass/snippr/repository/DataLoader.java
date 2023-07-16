package com.backendclass.snippr.repository;

import com.backendclass.snippr.models.Lang;
import com.backendclass.snippr.models.Snippet;
import com.backendclass.snippr.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SnippetRepository snippetRepository;

    @Override
    public void run(String...args) {
        loadData();
    }

    private void loadData () {
        loadUserData();
        loadSnippetData();
    }
    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user = new User("spartanginger@gmail.com","hashed!");
            User user1 = new User("bob@gmail.com","hashed!");
            userRepository.save(user);
            userRepository.save(user1);
            System.out.println("User table seeded! new user count is: " + userRepository.count());
        }
        System.out.println("user count is " + userRepository.count());

    }

    private void loadSnippetData() {
        if(snippetRepository.count() == 0) {
            User user = userRepository.getReferenceById((long)1);
            Snippet snippet = new Snippet("i++", Lang.JAVASCRIPT, user);
            Snippet snippet1 = new Snippet("i--", Lang.JAVASCRIPT, user);
            snippetRepository.save(snippet);
            snippetRepository.save(snippet1);
            System.out.println("Snippet Table seeded!");
        }
        System.out.println("snippet table count is: " + snippetRepository.count());
    }
}
