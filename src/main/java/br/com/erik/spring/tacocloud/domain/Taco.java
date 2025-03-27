package br.com.erik.spring.tacocloud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tacos")
@NoArgsConstructor
@AllArgsConstructor
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDateTime createdAt;

  private String imageUrl;

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @ManyToMany(targetEntity = Ingredient.class)
  @Size(min = 1, message = "You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;

  @PrePersist
  void createdAt() {
    this.createdAt = LocalDateTime.now();
  }

  public Taco(String name, String imageUrl, List<Ingredient> ingredients) {
    this.name = name;
    this.imageUrl = imageUrl;
    this.ingredients = ingredients;
  }
}
