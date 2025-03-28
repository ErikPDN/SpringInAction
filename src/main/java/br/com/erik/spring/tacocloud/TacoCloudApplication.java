package br.com.erik.spring.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.erik.spring.tacocloud.data.IngredientRepository;
import br.com.erik.spring.tacocloud.domain.Ingredient;

@SpringBootApplication
public class TacoCloudApplication {
  public static void main(String[] args) {
    SpringApplication.run(TacoCloudApplication.class, args);
  }

  @Bean
  public CommandLineRunner dataLoader(IngredientRepository repository) {
    return args -> {
      repository.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
      repository.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
      repository.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
      repository.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
      repository.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
      repository.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
      repository.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
      repository.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
      repository.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
      repository.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
    };
  }
}
