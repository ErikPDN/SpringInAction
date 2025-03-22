package br.com.erik.spring.tacocloud.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import br.com.erik.spring.tacocloud.services.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
  @Value("tacocloud.security.token.secret-key")
  private String secretKey;

  @Override
  public String generateToken(String username) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);

      String token = JWT.create()
          .withIssuer("tacocloud")
          .withSubject(username)
          .withExpiresAt(this.generateExpirationDate())
          .sign(algorithm);

      return token;
    } catch (JWTVerificationException e) {
      throw new RuntimeException("Error while generating token", e);
    }
  }

  @Override
  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);

      return JWT.require(algorithm)
          .withIssuer("tacocloud")
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException e) {
      return null;
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
  }
}
