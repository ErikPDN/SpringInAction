package br.com.erik.spring.tacocloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/design").permitAll() // Exemplo: URLs públicas
            .anyRequest().authenticated() // Requer autenticação para outras URLs
        )
        .formLogin(form -> form
            .loginPage("/login") // Página de login personalizada
            .permitAll())
        .logout(LogoutConfigurer::permitAll);

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    // Configuração de usuários em memória (para teste ou desenvolvimento)
    User.UserBuilder users = User.builder().passwordEncoder(passwordEncoder()::encode);

    return new InMemoryUserDetailsManager(
        users
            .username("buzz")
            .password("infinity")
            .roles("USER")
            .build(),
        users
            .username("woody")
            .password("bullseye")
            .roles("USER")
            .build());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
