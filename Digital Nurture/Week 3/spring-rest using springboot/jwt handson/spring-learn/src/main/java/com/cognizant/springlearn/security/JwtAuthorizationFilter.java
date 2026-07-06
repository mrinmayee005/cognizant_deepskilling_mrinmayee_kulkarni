package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hands-On 5: JWT Authorization Filter
 *
 * Intercepts every HTTP request and checks for a valid JWT in the
 * "Authorization: Bearer <token>" header.
 *
 * If the token is valid the request is allowed through; otherwise Spring
 * Security's default rejection kicks in (401 Unauthorized).
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final String JWT_SECRET = "secretkey";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("Start JwtAuthorizationFilter constructor");
        LOGGER.debug("AuthenticationManager: {}", authenticationManager);
    }

    /**
     * Called for every request that passes through the filter chain.
     * Checks for "Bearer " prefix in the Authorization header and validates the JWT.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Start doFilterInternal");

        String header = req.getHeader("Authorization");
        LOGGER.debug("Authorization header: {}", header);

        // If there is no Bearer token, continue without setting authentication
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        // Validate the JWT and build a Spring Security authentication object
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        // Store in the SecurityContext so the rest of the filter chain sees it
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);

        LOGGER.info("End doFilterInternal");
    }

    /**
     * Parses and validates the JWT from the request.
     *
     * @return a populated authentication token on success, or null on failure
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        LOGGER.info("Start getAuthentication");

        String token = request.getHeader("Authorization");

        if (token != null) {
            Jws<Claims> jws;
            try {
                // Strip "Bearer " prefix and parse
                jws = Jwts.parser()
                        .setSigningKey(JWT_SECRET)
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String user = jws.getBody().getSubject();
                LOGGER.debug("JWT subject (user): {}", user);

                if (user != null) {
                    // Return an authenticated token (no credentials, no authorities needed here)
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                LOGGER.warn("Invalid JWT token: {}", ex.getMessage());
                return null;
            }
        }

        LOGGER.info("End getAuthentication - no valid token");
        return null;
    }
}
