package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.config;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
            // no JWT found, hence proceed with next filter in the security filter chain, in this case, it is the normal auth process
        }

        // JWT found. validate and authenticate.

        final String jwt = authHeader.substring(7);
        final String username = jwtService.extractUsername(jwt);

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if(username != null && authentication == null){
            // user valid, but not yet authenticated, hence do set authentication process.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            System.out.println("jwt found");
            if(jwtService.isTokenValid(jwt, userDetails)){
                // token is valid
                System.out.println("jwt valid");
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null,
                                userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // we came into this because authentication from securitycontext was null, hence now we have authenticated
                // and set that authentication to the security context for subsequent access
            }
        }


        // either already authenticated or username not found or authenticated via above IF or jwt invalid via above IF,
        // in any case, proceed to next filter in security filter chain where in valid usernames will be caught
        // or if already authenticated the auth filter will be skipped, which is why we wouldn't need to pass credentials via basic auth.
        filterChain.doFilter(request,response);
        return;
    }
}
