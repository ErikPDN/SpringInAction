package br.com.erik.spring.tacocloud.web;

import br.com.erik.spring.tacocloud.data.IngredientRepository;
import br.com.erik.spring.tacocloud.data.TacoRepository;
import br.com.erik.spring.tacocloud.domain.Ingredient;
import br.com.erik.spring.tacocloud.domain.Order;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.erik.spring.tacocloud.domain.Ingredient.Type;
import br.com.erik.spring.tacocloud.domain.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

  private final IngredientRepository ingredientRepo;
  private final TacoRepository tacoRepository;

  public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepository) {
    this.ingredientRepo = ingredientRepo;
    this.tacoRepository = tacoRepository;
  }

  @GetMapping
  public String showDesignForm(Model model) {
      List<Ingredient> ingredients = new ArrayList<>();
      ingredientRepo.findAll().forEach(ingredients::add);

    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }

    model.addAttribute("taco", new Taco());

    return "design";
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @PostMapping
  public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
    if (errors.hasErrors()) {
      return "design";
    }

    Taco tacoSaved = tacoRepository.save(design);
    order.addDesign(tacoSaved);

    log.info("Processing design: {}", design);
    return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients.stream()
        .filter(ingredient -> ingredient.getType().equals(type))
        .collect(Collectors.toList());
  }
}
