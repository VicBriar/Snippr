package com.backendclass.snippr.controller;

import com.backendclass.snippr.exceptions.SnippetNotFoundException;
import com.backendclass.snippr.exceptions.UserNotFoundException;
import com.backendclass.snippr.models.Snippet;
import com.backendclass.snippr.models.User;
import com.backendclass.snippr.repository.SnippetRepository;
import com.backendclass.snippr.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class SnipprController {
    private final SnippetRepository snippetRepository;
    private final UserRepository userRepository;

    SnipprController(SnippetRepository snippetRepository, UserRepository userRepository) {
        this.snippetRepository = snippetRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/snippets")
    List<Snippet> allSnippets() {
        return snippetRepository.findAll();
    }

    @GetMapping("/snippets/{id}")
    Snippet oneSnippet(@PathVariable Long id) {
        return snippetRepository.findById(id)
                .orElseThrow(()-> new SnippetNotFoundException(id));
    }

    @PostMapping("/snippets")
    Snippet newSnippet(@RequestBody Snippet newSnippet) {
        return snippetRepository.save(newSnippet);
    }

    @GetMapping("/users")
    List<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User oneUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }
}