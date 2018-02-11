package com.config.security.component;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * Customization AccessDeniedHandler, which will determine the
 * behavior of the filter ExceptionTranslationFilter
 * when an error occurs  will send the client information in
 * the form of json about the error
 *
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            // response.sendError(HttpServletResponse.SC_FORBIDDEN,
            // accessDeniedException.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            out.print("{\"message\":\"" + accessDeniedException.getMessage()
                    + "\", \"access-denied\":true,\"cause\":\"SC_FORBIDDEN\"}");
            out.flush();
            out.close();
    }
}
