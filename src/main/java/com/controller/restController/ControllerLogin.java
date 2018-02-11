package com.controller.restController;

import com.controller.model.Headers;
import com.controller.model.JsonResponse;
import com.controller.model.UserAuthenticationData;
import com.services.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/login")
public class ControllerLogin {

    @Autowired
    AuthenticationUser authenticationUser;

    HttpHeaders responseHeaders;

    @RequestMapping(value = "/authentication", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public ResponseEntity<JsonResponse> authenticationUser(@RequestBody UserAuthenticationData userAuthenticationData) {
            String tokenAuthentication = authenticationUser.authenticationUser(userAuthenticationData);
        if (tokenAuthentication != null) {
            responseHeaders = new HttpHeaders();
            responseHeaders.add("X-Auth-Token", tokenAuthentication);
            return new ResponseEntity<>(new JsonResponse("OK", ""), responseHeaders, HttpStatus.OK);
        } else return new ResponseEntity<>(new JsonResponse("Unauthorized", "401"), Headers.getHeaders(), HttpStatus.UNAUTHORIZED);
    }

}
