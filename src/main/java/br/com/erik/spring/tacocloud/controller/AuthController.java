package br.com.erik.spring.tacocloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erik.spring.tacocloud.controller.dto.LoginRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.RegisterRequestDTO;
import br.com.erik.spring.tacocloud.services.AuthService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
    try {
      var response = this.authService.login(loginRequest.username(), loginRequest.password());
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequest) {
    try {
      this.authService.register(registerRequest.username(), registerRequest.password());
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
