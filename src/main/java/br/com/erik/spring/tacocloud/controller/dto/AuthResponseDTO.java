package br.com.erik.spring.tacocloud.controller.dto;

public record AuthResponseDTO(UserDTO user, String token) {
}
