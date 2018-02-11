package com.services.servicesImpl;

import com.controller.model.UserAuthenticationData;
import com.config.security.component.TokenAuthentication;
import com.config.security.component.TokenUtils;
import com.services.AuthenticationUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenicationUserImpl implements AuthenticationUser {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenicationUserImpl.class);

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * The service for user authentication, in case of luck, returns a token, or null
     * @param userAuthenticationData
     * @return
     */
    @Override
    public String authenticationUser(UserAuthenticationData userAuthenticationData) {
        String login = userAuthenticationData.getLogin();
        String password = userAuthenticationData.getPassword();

        if (login != null && password != null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
                if (userDetails != null && userDetails.getUsername().equals(login) && userDetails.getPassword().equals(password)) {
                    String token = TokenUtils.createToken(userDetails);
                    TokenAuthentication authentication = new TokenAuthentication(userDetails, null, userDetails.getAuthorities());
                    authentication.setToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    LOG.info("Create token: " + token);
                    return token;
                }
            }

        return null;
    }
}
