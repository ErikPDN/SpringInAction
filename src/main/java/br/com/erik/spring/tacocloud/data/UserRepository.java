package br.com.erik.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import br.com.erik.spring.tacocloud.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
