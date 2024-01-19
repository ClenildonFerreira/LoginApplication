package io.github.clenildonferreira.devtechnicaltestapi.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
    super(message);
    }
}
