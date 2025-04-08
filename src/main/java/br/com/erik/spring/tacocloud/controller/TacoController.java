package br.com.erik.spring.tacocloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.services.IngredientService;
import br.com.erik.spring.tacocloud.services.TacoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/designTaco")
@RequiredArgsConstructor
public class TacoController {
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

  @PostMapping("/taco")
  public ResponseEntity<?> saveTaco(@RequestBody TacoRequestDTO tacoRequest) {
    try {
      this.tacoService.saveTaco(tacoRequest);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/taco")
  public ResponseEntity<?> getTacos() {
    try {
      var taco = this.tacoService.getTacos();
      return ResponseEntity.ok(taco);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/taco/{id}")
  public ResponseEntity<?> getTacoById(@PathVariable Long id) {
    try {
      var taco = this.tacoService.getTacoById(id);
      return ResponseEntity.ok(taco);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/taco/{id}")
  public ResponseEntity<?> deleteTaco(@PathVariable Long id) {
    try {
      this.tacoService.deleteTaco(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/taco/{id}")
  public ResponseEntity<?> updateTaco(@PathVariable Long id, @RequestBody TacoRequestDTO tacoRequest) {
    try {
      this.tacoService.updateTaco(id, tacoRequest);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
