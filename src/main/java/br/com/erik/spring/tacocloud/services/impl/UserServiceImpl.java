package br.com.erik.spring.tacocloud.services.impl;

import org.springframework.stereotype.Service;

import br.com.erik.spring.tacocloud.controller.dto.UserResponseDTO;
import br.com.erik.spring.tacocloud.data.UserRepository;
import br.com.erik.spring.tacocloud.domain.User;
import br.com.erik.spring.tacocloud.services.UserService;
import br.com.erik.spring.tacocloud.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public UserResponseDTO getUserById(Long id) {
    User user = this.userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found"));

    var userDTO = new UserResponseDTO(user.getUsername(), user.getFullname(),
        user.getStreet(), user.getCity(), user.getState(), user.getZip(),
        user.getPhoneNumber());

    return userDTO;
  }

}
