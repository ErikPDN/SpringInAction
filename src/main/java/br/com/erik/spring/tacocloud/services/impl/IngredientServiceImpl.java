package br.com.erik.spring.tacocloud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.erik.spring.tacocloud.data.IngredientRepository;
import br.com.erik.spring.tacocloud.domain.Ingredient;
import br.com.erik.spring.tacocloud.services.IngredientService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
  private final IngredientRepository ingredientRepository;

  @Override
  public List<Ingredient> getIngredients() {
    return this.ingredientRepository.findAll();
  }
}
