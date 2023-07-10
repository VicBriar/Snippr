package com.backendclass.snippr.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("could not find user " + id);
    }
}
