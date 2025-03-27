package br.com.erik.spring.tacocloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.services.IngredientService;
import br.com.erik.spring.tacocloud.services.TacoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/designTaco")
@RequiredArgsConstructor
public class DesignController {
  private final IngredientService ingredientService;
  private final TacoService tacoService;

  @GetMapping()
  public ResponseEntity<?> getIngredients() {
    try {
      var ingredients = this.ingredientService.getIngredients();
      return ResponseEntity.ok(ingredients);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> saveTaco(@RequestBody TacoRequestDTO tacoRequest) {
    try {
      var respose = this.tacoService.saveTaco(tacoRequest);
      return ResponseEntity.ok(respose);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
