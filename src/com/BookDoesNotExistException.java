package com;

public class BookDoesNotExistException extends Exception{

    @Override
    public String toString() {
        return "The Book does not exists !";
    }
}
