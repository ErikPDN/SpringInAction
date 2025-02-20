package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
