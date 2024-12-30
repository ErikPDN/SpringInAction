package br.com.erik.spring.tacocloud.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  private final DataSource dataSource;

  public SecurityConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

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
    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

    users.setUsersByUsernameQuery(
        "select username, password, enabled from Users where username = ?");
    users.setAuthoritiesByUsernameQuery(
        "select username, authority from UserAuthorities where username = ?");

    return users;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
