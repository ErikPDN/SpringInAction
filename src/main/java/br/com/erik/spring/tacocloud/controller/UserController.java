package br.com.erik.spring.tacocloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erik.spring.tacocloud.controller.dto.UserRequestDTO;
import br.com.erik.spring.tacocloud.services.UserService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    try {
      var response = this.userService.getUserById(id);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequest) {
    try {
      this.userService.updateUser(id, userRequest);
      Thread.sleep(2000);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
