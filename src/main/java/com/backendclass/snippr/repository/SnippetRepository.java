package com.backendclass.snippr.repository;

import com.backendclass.snippr.models.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet,Long> {
}
