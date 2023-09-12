package com.samkingworld.librarySystem.exception;

import com.samkingworld.librarySystem.model.User;

public class UserException extends RuntimeException{


    public UserException(String message){
        super(message);
    }
}
