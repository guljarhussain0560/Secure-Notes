package com.guljar.notes.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
public class UserAgentFilter extends OncePerRequestFilter {
    //cpnditional filter based on User-Agent header
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response , FilterChain filterChain)
    throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null && userAgent.contains("Mozilla")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User-Agent header is missing");
            return;
        }
        filterChain.doFilter(request, response);
    }

}
