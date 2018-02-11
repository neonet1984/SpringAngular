package com.controller.model;

import org.springframework.http.HttpHeaders;

public class Headers {
    private static HttpHeaders responseHeaders;
    public static HttpHeaders getHeaders(){
        if(responseHeaders==null) {
            responseHeaders = new HttpHeaders();
            responseHeaders.add("Access-Control-Allow-Origin", "http://localhost:4200");
        }
        return responseHeaders;
    }
}
