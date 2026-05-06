//package Group5.Project3.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * SecurityConfig
// *
// * @author: Dima Krayilo
// * @since: 4/29/2026
// * @version: 0.1.0
// *
// */
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()
//                )
//                .csrf(csrf -> csrf.disable()) // Often needed for POST/PUT if security is active
//                .formLogin(form -> form.disable()) // Specifically hides the login page
//                .httpBasic(basic -> basic.disable()); // Specifically hides the popup prompt
//        return http.build();
//    }
//}
