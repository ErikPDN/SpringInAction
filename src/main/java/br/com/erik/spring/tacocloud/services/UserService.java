package br.com.erik.spring.tacocloud.services;

import br.com.erik.spring.tacocloud.controller.dto.UserRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.UserResponseDTO;

public interface UserService {
  UserResponseDTO getUserById(Long id);

  void updateUser(Long id, UserRequestDTO user);
}
