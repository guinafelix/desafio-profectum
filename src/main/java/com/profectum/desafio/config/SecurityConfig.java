package com.profectum.desafio.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;	


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
    SecurityFilter securityFilter;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .cors(withDefaults())
                .csrf((csrf) -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/usuario/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/perfil").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/perfis").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/docs.html").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/disciplina").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/curso").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/curso").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/usuario/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuario/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/curso/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
	

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration  authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")); // or simply "*"
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}