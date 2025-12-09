package org.example.fatsecret.Exceptions;

public class NameEmptyException extends RuntimeException {
    public NameEmptyException() {
        super ("Поле name пустое");
    }
}
