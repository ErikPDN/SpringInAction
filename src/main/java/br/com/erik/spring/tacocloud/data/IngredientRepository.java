package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();  // fornece um iterador, o que significa que se pode percorre os elementos um por um
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
