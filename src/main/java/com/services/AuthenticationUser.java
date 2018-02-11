package com.services;

import com.controller.model.UserAuthenticationData;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationUser {
     String authenticationUser(UserAuthenticationData userAuthenticationData);
}
