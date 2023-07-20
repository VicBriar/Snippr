package com.backendclass.snippr.services;

import com.backendclass.snippr.DTOS.SnippetDTO;

import java.util.List;

public interface SnippetService {
    List<SnippetDTO> getAllSnippets();
    SnippetDTO getSnippetById(Long id);
    SnippetDTO createSnippet(SnippetDTO snippetDTO);
    //todo
    //List<SnippetDTO>  getSnippetsByUser();
}
