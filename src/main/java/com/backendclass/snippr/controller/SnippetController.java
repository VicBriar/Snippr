package com.backendclass.snippr.controller;

import com.backendclass.snippr.exceptions.SnippetNotFoundException;
import com.backendclass.snippr.models.Snippet;
import com.backendclass.snippr.repository.SnippetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
class SnippetController {
    private final SnippetRepository snippetRepository;

    SnippetController(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
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