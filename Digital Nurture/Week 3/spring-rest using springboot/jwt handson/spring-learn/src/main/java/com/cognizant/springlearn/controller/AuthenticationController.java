package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Hands-On 3 & 4: Authentication controller that validates Basic credentials
 * and returns a JWT token.
 *
 * Flow:
 *   1. Client sends: GET /authenticate  with  Authorization: Basic base64(user:pwd)
 *   2. Spring Security validates the credentials via in-memory user store.
 *   3. This method reads the Authorization header, extracts the username,
 *      generates a signed JWT, and returns it in the response body.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    /** Secret used to sign the JWT.  Keep this in application.properties in real projects. */
    private static final String JWT_SECRET = "secretkey";

    /** Token validity: 20 minutes (milliseconds) */
    private static final long TOKEN_VALIDITY_MS = 1_200_000L;

    /**
     * Hands-On 3: Returns a JWT for an authenticated user.
     *
     * @param authHeader  Value of the "Authorization" HTTP request header.
     *                    Spring automatically injects it from the incoming request.
     * @return            Map with a single "token" key.
     */
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("Start authenticate");
        LOGGER.debug("Authorization header received: {}", authHeader);

        // Step 1: decode username from Basic auth header
        String user = getUser(authHeader);
        LOGGER.debug("Authenticated user: {}", user);

        // Step 2: generate JWT for that user
        String token = generateJwt(user);
        LOGGER.debug("Generated token: {}", token);

        // Step 3: wrap in response map
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("End authenticate");
        return response;
    }

    // -------------------------------------------------------------------------
    // Hands-On 4 helper: decode the username from the Basic auth header
    // -------------------------------------------------------------------------

    /**
     * Extracts the username from a Basic Authentication header value.
     *
     * @param authHeader  e.g. "Basic dXNlcjpwd2Q="
     * @return            username part (before the colon)
     */
    private String getUser(String authHeader) {
        LOGGER.info("Start getUser");

        // Strip the "Basic " prefix (7 characters)
        String encodedCredentials = authHeader.substring("Basic ".length());
        LOGGER.debug("Base64 encoded credentials: {}", encodedCredentials);

        // Decode from Base64 → "user:pwd"
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);           // "user:pwd"
        LOGGER.debug("Decoded credentials: {}", credentials);

        // Extract username (everything before the first colon)
        String user = credentials.substring(0, credentials.indexOf(':'));
        LOGGER.debug("Extracted user: {}", user);

        LOGGER.info("End getUser");
        return user;
    }

    // -------------------------------------------------------------------------
    // Hands-On 4 helper: build and sign the JWT
    // -------------------------------------------------------------------------

    /**
     * Builds a signed JWT for the given username.
     * Token is valid for {@value #TOKEN_VALIDITY_MS} ms (20 minutes).
     *
     * @param user  authenticated username
     * @return      compact JWT string
     */
    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt");

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());

        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_MS));

        // Sign with HMAC-SHA256 using our secret key
        builder.signWith(SignatureAlgorithm.HS256, JWT_SECRET);

        String token = builder.compact();
        LOGGER.debug("JWT: {}", token);

        LOGGER.info("End generateJwt");
        return token;
    }
}
