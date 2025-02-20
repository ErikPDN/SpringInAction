package br.com.erik.spring.tacocloud.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.erik.spring.tacocloud.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
