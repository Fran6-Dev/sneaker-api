package com.francis.sneaker_api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Utilisateur introuvable : " + id);
    }
}
