package br.com.erik.spring.tacocloud.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.com.erik.spring.tacocloud.data.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    var user = this.userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

    return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
  }
}
