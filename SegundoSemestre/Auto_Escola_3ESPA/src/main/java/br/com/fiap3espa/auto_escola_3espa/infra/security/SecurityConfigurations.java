package br.com.fiap3espa.auto_escola_3espa.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurations {

    @Autowired SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm
                        -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Login: público
                        .requestMatchers("/login").permitAll()
                        // Alterar própria senha deve vir ANTES de /usuarios/** (regra mais específica primeiro)
                        .requestMatchers(org.springframework.http.HttpMethod.PATCH, "/usuarios/senha").authenticated()
                        // CRUD completo de usuários: apenas ADMIN
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")
                        // Instrutores: ADMIN ou USER
                        .requestMatchers("/instrutores/**").hasAnyRole("ADMIN", "USER")
                        // Qualquer outra rota: autenticado
                        .anyRequest().authenticated()
                        .requestMatchers("/alunos/**").hasAnyRole("ADMIN", "USER")
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}