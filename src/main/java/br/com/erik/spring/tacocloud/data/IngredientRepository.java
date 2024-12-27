package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
