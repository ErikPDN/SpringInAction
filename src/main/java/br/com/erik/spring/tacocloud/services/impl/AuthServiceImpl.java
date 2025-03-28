package br.com.erik.spring.tacocloud.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.erik.spring.tacocloud.controller.dto.AuthResponseDTO;
import br.com.erik.spring.tacocloud.controller.dto.UserTokenResponseDTO;
import br.com.erik.spring.tacocloud.data.UserRepository;
import br.com.erik.spring.tacocloud.domain.User;
import br.com.erik.spring.tacocloud.services.AuthService;
import br.com.erik.spring.tacocloud.services.TokenService;
import br.com.erik.spring.tacocloud.services.exceptions.InvalidPasswordException;
import br.com.erik.spring.tacocloud.services.exceptions.UserAlreadyExistsException;
import br.com.erik.spring.tacocloud.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final TokenService tokenService;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public AuthResponseDTO login(String username, String password) {
    var user = this.userRepository.findByUsername(username)
        .orElseThrow(() -> new UserNotFoundException("User not found"));

    if (!this.passwordEncoder.matches(password, user.getPassword())) {
      throw new InvalidPasswordException("Invalid Password");
    }

    var token = this.tokenService.generateToken(username);
    Long id = user.getId();
    var userToken = new UserTokenResponseDTO(id, username);

    return new AuthResponseDTO(userToken, token);
  }

  @Override
  public void register(String username, String password) {
    var user = this.userRepository.findByUsername(username);

    if (!user.isEmpty()) {
      throw new UserAlreadyExistsException("User already exists");
    }

    this.userRepository.save(new User(username, this.passwordEncoder.encode(password)));
  }
}
