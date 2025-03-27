package br.com.erik.spring.tacocloud.services;

import java.util.List;

import br.com.erik.spring.tacocloud.domain.Ingredient;

public interface IngredientService {
  List<Ingredient> getIngredients();
}
