package Group5.Project3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 *
 * @author: Dima Krayilo
 * @since: 4/29/2026
 * @version: 0.1.0
 *
 */
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable for local dev testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/**", "/skills/**").permitAll() // Let your new endpoints through
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
