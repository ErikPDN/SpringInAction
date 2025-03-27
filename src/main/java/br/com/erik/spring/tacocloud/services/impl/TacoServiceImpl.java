package br.com.erik.spring.tacocloud.services.impl;

import org.springframework.stereotype.Service;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.TacoResponseDTO;
import br.com.erik.spring.tacocloud.data.TacoRepository;
import br.com.erik.spring.tacocloud.domain.Taco;
import br.com.erik.spring.tacocloud.services.TacoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TacoServiceImpl implements TacoService {
  private final TacoRepository tacoRepository;

  @Override
  public TacoResponseDTO saveTaco(TacoRequestDTO tacoRequestDTO) {
    var taco = new Taco(tacoRequestDTO.name(), tacoRequestDTO.url(), tacoRequestDTO.ingredients());
    this.tacoRepository.save(taco);

    var tacoDTO = new TacoResponseDTO(taco.getName(), taco.getImageUrl());
    return tacoDTO;
  }
}
