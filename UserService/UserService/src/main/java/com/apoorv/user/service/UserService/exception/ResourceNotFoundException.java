package com.apoorv.user.service.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException()
    {
        super("not found on server");
    }
    public ResourceNotFoundException(String msge)
    {
        super(msge);
    }
}
