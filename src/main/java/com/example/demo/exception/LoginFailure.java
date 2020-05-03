package com.example.demo.exception;

public class LoginFailure extends Exception  {

    private static final long serialVersionUID = -4701805079010368L;

    public LoginFailure() {
        super();
    }

    public LoginFailure(final String message){
        super(message);
    }
}
