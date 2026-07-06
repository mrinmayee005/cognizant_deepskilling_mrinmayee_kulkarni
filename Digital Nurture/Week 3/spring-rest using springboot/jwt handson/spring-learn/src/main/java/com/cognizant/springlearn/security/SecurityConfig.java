package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security configuration covering all three stages of the hands-on:
 *
 *  Hands-On 1 – @EnableWebSecurity locks down every URL.
 *  Hands-On 2 – In-memory users (admin / user) with BCrypt passwords and
 *               role-based URL authorisation.
 *  Hands-On 3 to 5 – /authenticate is accessible to both roles; all other
 *               requests are validated via a JWT Bearer token filter instead
 *               of checking the user/role every time.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    // -------------------------------------------------------------------------
    // Hands-On 2: In-memory users
    // -------------------------------------------------------------------------

    /**
     * Defines two in-memory users:
     *   admin / pwd  →  ROLE_ADMIN
     *   user  / pwd  →  ROLE_USER
     *
     * NOTE: In production, user credentials are stored in a database and
     * loaded via UserDetailsService (covered in the Spring Data JPA module).
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Start configure(AuthenticationManagerBuilder)");

        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password(passwordEncoder().encode("pwd"))
                    .roles("ADMIN")
                .and()
                .withUser("user")
                    .password(passwordEncoder().encode("pwd"))
                    .roles("USER");

        LOGGER.info("End configure(AuthenticationManagerBuilder)");
    }

    /**
     * BCrypt password encoder bean – required when storing encoded passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Creating BCryptPasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }

    // -------------------------------------------------------------------------
    // Hands-On 2 + 5: URL authorization & JWT filter
    // -------------------------------------------------------------------------

    /**
     * HTTP security rules:
     *
     *  • CSRF disabled (stateless REST API).
     *  • HTTP Basic enabled so that the /authenticate endpoint can receive
     *    the initial username/password.
     *  • /authenticate  – accessible to USER and ADMIN roles.
     *  • All other requests – must carry a valid JWT Bearer token
     *    (validated by JwtAuthorizationFilter).
     *
     * Hands-On 2 note: the original antMatcher for /countries is commented
     * out below for reference; in the JWT phase ".anyRequest().authenticated()"
     * replaces per-URL role checks because the filter handles authorization.
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        LOGGER.info("Start configure(HttpSecurity)");

        httpSecurity
            .csrf().disable()
            .httpBasic()           // allows Basic auth for /authenticate
            .and()
            .authorizeRequests()
                // Hands-On 2 reference (still works if JWT filter is removed):
                // .antMatchers("/countries").hasRole("USER")

                // /authenticate can be called by either role to obtain a token
                .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")

                // Every other endpoint requires a valid (JWT) authentication
                .anyRequest().authenticated()
            .and()
            // Hands-On 5: plug in the JWT validation filter
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));

        LOGGER.info("End configure(HttpSecurity)");
    }
}
