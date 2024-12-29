package br.com.erik.spring.tacocloud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
public class Ingredient {
  @Id
  private final String id;
  private final String name;
  private final Type type;

  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
