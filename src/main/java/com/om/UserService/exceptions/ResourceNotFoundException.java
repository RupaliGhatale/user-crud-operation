package com.om.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("ResourceNotFoundException !!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
