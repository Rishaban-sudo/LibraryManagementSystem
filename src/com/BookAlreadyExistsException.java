package com;

public class BookAlreadyExistsException extends Exception{

    @Override
    public String toString() {
        return "The Book already exists !";
    }
}

