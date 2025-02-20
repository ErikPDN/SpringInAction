package br.com.erik.spring.tacocloud.services;

public interface TokenService {
  String generateToken(String username);

  String validateToken(String token);
}
