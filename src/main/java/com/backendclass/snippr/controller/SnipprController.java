package com.backendclass.snippr.controller;

import com.backendclass.snippr.exceptions.SnippetNotFoundException;
import com.backendclass.snippr.models.Snippet;
import com.backendclass.snippr.repository.SnippetRepository;
import com.backendclass.snippr.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
class SnipprController {
    private final SnippetRepository snippetRepository;
    private final UserRepository userRepository;

    SnipprController(SnippetRepository snippetRepository, UserRepository userRepository) {
        this.snippetRepository = snippetRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    List<Snippet> all() {
        return snippetRepository.findAll();
    }

    @GetMapping("/{id}")
    Snippet one(@PathVariable Long id) {
        return snippetRepository.findById(id)
                .orElseThrow(()-> new SnippetNotFoundException(id));
    }

    @PostMapping
    Snippet newSnippet(@RequestBody Snippet newSnippet) {
        return snippetRepository.save(newSnippet);
    }
}