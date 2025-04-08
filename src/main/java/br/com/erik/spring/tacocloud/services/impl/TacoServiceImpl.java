package br.com.erik.spring.tacocloud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.erik.spring.tacocloud.controller.dto.TacoRequestDTO;
import br.com.erik.spring.tacocloud.controller.dto.TacoResponseDTO;
import br.com.erik.spring.tacocloud.data.TacoRepository;
import br.com.erik.spring.tacocloud.domain.Taco;
import br.com.erik.spring.tacocloud.services.TacoService;
import br.com.erik.spring.tacocloud.services.exceptions.TacoNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TacoServiceImpl implements TacoService {
  private final TacoRepository tacoRepository;

  @Override
  public void saveTaco(TacoRequestDTO tacoRequestDTO) {
    System.out.println("TacoRequestDTO recebido: " + tacoRequestDTO);
    var taco = new Taco(tacoRequestDTO.name(), tacoRequestDTO.url(), tacoRequestDTO.ingredients());
    this.tacoRepository.save(taco);
  }

  @Override
  public List<TacoResponseDTO> getTacos() {
    var tacos = this.tacoRepository.findAll();
    return tacos.stream()
        .map(taco -> new TacoResponseDTO(taco.getId(), taco.getName(), taco.getImageUrl(), taco.getIngredients()))
        .toList();
  }

  @Override
  public TacoResponseDTO getTacoById(Long id) {
    var taco = this.tacoRepository.findById(id).orElseThrow(() -> new TacoNotFoundException("Taco not found"));
    return new TacoResponseDTO(taco.getId(), taco.getName(), taco.getImageUrl(), taco.getIngredients());
  }

  @Override
  public void deleteTaco(Long id) {
    this.tacoRepository.deleteById(id);
  }

  @Override
  public void updateTaco(Long id, TacoRequestDTO tacoRequestDTO) {
    var taco = this.tacoRepository.findById(id).orElseThrow(() -> new TacoNotFoundException("Taco not found"));
    taco.setName(tacoRequestDTO.name());
    taco.setImageUrl(tacoRequestDTO.url());
    taco.setIngredients(tacoRequestDTO.ingredients());
    this.tacoRepository.save(taco);
  }
}
