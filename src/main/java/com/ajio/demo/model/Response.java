package com.ajio.demo.model;

public class Response {
    private final String jwt;
    public Response(String jwt){
        this.jwt=jwt;
    }
    public String getJwt(){
        return jwt;
    }
}
