package com.services;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String userName,String password);
}
