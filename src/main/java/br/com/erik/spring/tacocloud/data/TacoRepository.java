package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Taco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {

}
