package br.com.erik.spring.tacocloud.services;

import br.com.erik.spring.tacocloud.controller.dto.AuthResponseDTO;

public interface AuthService {
  AuthResponseDTO login(String username, String password);

  void register(String username, String password);
}
