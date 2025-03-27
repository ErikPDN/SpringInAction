package br.com.erik.spring.tacocloud.controller.dto;

import java.util.List;

import br.com.erik.spring.tacocloud.domain.Ingredient;

public record TacoRequestDTO(String name, String url, List<Ingredient> ingredients) {
}
