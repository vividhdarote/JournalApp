package com.vividhdarote.journalismApp.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        String username = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "Unknown";
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("text/plain");
        response.getWriter().write("Dear " + username + "! You don't have admin access.");
    }
}
