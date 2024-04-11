//package com.springapp.iaBiletclone.config;
//
//
//import com.springapp.iaBiletclone.service.JwtRequestFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//public class JwtSecurityConfig {
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//
//        return http
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/").permitAll()
//                                .requestMatchers("/authenticate").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/addCity", "/addEventCategory").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.DELETE, "/deleteCity", "/deleteEventCategory").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/addEvent", "/addLocation", "/addTicketCategory", "/generateVoucher").hasAnyRole("ADMIN", "OWNER")
//                                .requestMatchers(HttpMethod.GET, "/getAllCategory", "/getOrders").hasAnyRole("ADMIN", "OWNER")
//                                .requestMatchers(HttpMethod.DELETE, "/deleteLocation").hasAnyRole("ADMIN", "OWNER")
//                                .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
////@PreAuthorize("hasRole('ADMIN') or hasRole('OWNER')")
//
//}
