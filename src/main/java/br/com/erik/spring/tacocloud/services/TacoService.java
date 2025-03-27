package br.com.erik.spring.tacocloud.services;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.TacoResponseDTO;

public interface TacoService {
  TacoResponseDTO saveTaco(TacoRequestDTO tacoRequestDTO);
}
