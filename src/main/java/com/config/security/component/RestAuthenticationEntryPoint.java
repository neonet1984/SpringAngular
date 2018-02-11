package com.config.security.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Customization AuthenticationEntryPoint, which will determine the behavior of the filter
 * ExceptionTranslationFilter in the situation of an unauthorized request,
 * will send the client information in the form of json about the access error
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = response.getWriter();
        out.print("{\"message\":\""+ authException.getMessage() + "\", \"access-denied\":true,\"cause\":\"SC_UNAUTHORIZED\"}");
        out.flush();
        out.close();
    }
}
