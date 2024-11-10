package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
