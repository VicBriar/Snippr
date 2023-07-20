//package com.backendclass.snippr.controller;
//
//import com.backendclass.snippr.DTOS.SnippetDTO;
//import com.backendclass.snippr.exceptions.SnippetNotFoundException;
//import com.backendclass.snippr.exceptions.UserNotFoundException;
//import com.backendclass.snippr.models.Lang;
//import com.backendclass.snippr.models.Snippet;
//import com.backendclass.snippr.models.User;
//import com.backendclass.snippr.repository.SnippetRepository;
//import com.backendclass.snippr.repository.UserRepository;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//class UserController {
//    private final UserRepository userRepository;
//
//    UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/snippets")
//    List<Snippet> allSnippets() {
//        return snippetRepository.findAll();
//    }
//
//    @GetMapping("/snippets/{id}")
//    Snippet oneSnippet(@PathVariable Long id) {
//        return snippetRepository.findById(id)
//                .orElseThrow(()-> new SnippetNotFoundException(id));
//    }
//
//    @PostMapping("/snippets")
//    @ResponseStatus(HttpStatus.CREATED)
//    ResponseEntity<String> addSnippet(@Valid @RequestBody SnippetDTO dto) {
//        Snippet newSnippet = dto.mapDTOToEntity(dto);
//        snippetRepository.save(newSnippet);
//        return ResponseEntity.ok("snippet created");
//    }
//
//    @GetMapping("/users")
//    List<User> allUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    User oneUser(@PathVariable Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(()-> new UserNotFoundException(id));
//    }
//
////    private Snippet convertToEntity(SnippetDTO snippetDTO) throws ParseException {
////        Snippet snippet = modelMapper.map();
////    }
//}