package br.com.erik.spring.tacocloud.controller.dto;

public record AuthResponseDTO(UserTokenResponseDTO user, String token) {
}
