package br.com.erik.spring.tacocloud.services;

import java.util.List;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.TacoResponseDTO;

public interface TacoService {
  void saveTaco(TacoRequestDTO tacoRequestDTO);

  List<TacoResponseDTO> getTacos();

  void deleteTaco(Long id);

  TacoResponseDTO getTacoById(Long id);

  void updateTaco(Long id, TacoRequestDTO tacoRequestDTO);
}
