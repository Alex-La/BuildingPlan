package org.example.exception;

public class EntityAlreadyExistException extends Exception{
    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
