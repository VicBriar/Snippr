package com.backendclass.snippr.services.implementations;

import com.backendclass.snippr.DTOS.SnippetDTO;
import com.backendclass.snippr.exceptions.SnippetNotFoundException;
import com.backendclass.snippr.models.Snippet;
import com.backendclass.snippr.models.User;
import com.backendclass.snippr.repository.SnippetRepository;
import com.backendclass.snippr.repository.UserRepository;
import com.backendclass.snippr.services.SnippetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SnippetServiceImplementation implements SnippetService {

    final UserRepository userRepository;
    final SnippetRepository snippetRepository;

    SnippetServiceImplementation(UserRepository userRepository, SnippetRepository snippetRepository) {
        this.userRepository = userRepository;
        this.snippetRepository = snippetRepository;
    }

    private Snippet mapDTOToEntity (SnippetDTO dto) {
        Snippet snippet = new Snippet();
        User user = userRepository.getReferenceById(dto.getUserId());
        snippet.setSnippet(dto.getSnippet());
        snippet.setLanguage(dto.getLanguage());
        snippet.setUser(user);

        return snippet;
    }
    private SnippetDTO mapEntityToDTO (Snippet snippet) {
        SnippetDTO snippetDto = new SnippetDTO();
        Long userId = snippet.getUser().getId();
        snippetDto.setId(snippet.getId());
        snippetDto.setSnippet(snippet.getSnippet());
        snippetDto.setLanguage(snippet.getLanguage());
        snippetDto.setUserId(userId);

        return snippetDto;
    }
    @Override
    public List<SnippetDTO> getAllSnippets() {
        List<Snippet> snippets = snippetRepository.findAll();
        List<SnippetDTO> snippetDtos = new ArrayList<>();
        snippets.forEach((snippet) -> {
            snippetDtos.add(mapEntityToDTO(snippet));
        });

        return snippetDtos;
    }

    @Override
    public SnippetDTO getSnippetById(Long id) {
        Snippet snippet = snippetRepository.findById(id)
                .orElseThrow(()-> new SnippetNotFoundException(id));
        return mapEntityToDTO(snippet);
    }

    @Override
    public SnippetDTO createSnippet(SnippetDTO snippetDTO) {
        Snippet snippet = mapDTOToEntity(snippetDTO);
        snippetRepository.save(snippet);
        return mapEntityToDTO(snippet);
    }
}
