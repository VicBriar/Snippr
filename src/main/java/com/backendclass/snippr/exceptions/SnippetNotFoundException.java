package com.backendclass.snippr.exceptions;

public class SnippetNotFoundException extends RuntimeException {

    public SnippetNotFoundException(Long id) {
        super("could not find snippet " + id);
    }
}
