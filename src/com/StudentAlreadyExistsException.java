package com;

public class StudentAlreadyExistsException extends Exception{

    @Override
    public String toString() {
        return "The Student is already a member !";
    }

}
