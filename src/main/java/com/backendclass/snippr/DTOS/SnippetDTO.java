package com.backendclass.snippr.DTOS;


import com.backendclass.snippr.models.Lang;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SnippetDTO {
    public long id;
    @NotEmpty(message = "you must provide a snippet")
    @Size(min=3, message = "you must write more than 3 characters of code")
    public String snippet;
    @NotNull(message = "you must provide a language, like JAVA or JAVASCRIPT")
    public Lang language;
    @NotNull(message="you must provide an author id for this snippet")
    public Long userId;

    public SnippetDTO(String snippet,Lang language,Long userId){
        this.snippet = snippet;
        this.language = language;
        this.userId = userId;
    }
    public SnippetDTO(){}
}
