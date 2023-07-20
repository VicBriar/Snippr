package com.backendclass.snippr.controller;

import com.backendclass.snippr.DTOS.SnippetDTO;
import com.backendclass.snippr.services.SnippetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
class SnippetController {
    final SnippetService snippetService;

    SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping
    List<SnippetDTO> allSnippets() {
        return snippetService.getAllSnippets();
    }

    @GetMapping("/{id}")
    SnippetDTO oneSnippet(@PathVariable Long id) {
        return snippetService.getSnippetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<SnippetDTO> addSnippet(@Valid @RequestBody SnippetDTO dto) {
        SnippetDTO newSnippetDTO = snippetService.createSnippet(dto);
        return new ResponseEntity<>(newSnippetDTO, HttpStatus.CREATED);
    }
}