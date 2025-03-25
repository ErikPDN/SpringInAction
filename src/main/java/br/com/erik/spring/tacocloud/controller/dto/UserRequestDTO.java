package br.com.erik.spring.tacocloud.controller.dto;

public record UserRequestDTO(String username, String fullName, String street, String city,
    String state, String zip, String phoneNumber) {
}
