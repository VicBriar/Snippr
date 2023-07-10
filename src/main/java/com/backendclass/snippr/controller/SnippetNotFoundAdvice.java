package com.backendclass.snippr.controller;

import com.backendclass.snippr.exceptions.SnippetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SnippetNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SnippetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String snippetNotFoundHandler(SnippetNotFoundException exception) {
        return exception.getMessage();
    }
}
