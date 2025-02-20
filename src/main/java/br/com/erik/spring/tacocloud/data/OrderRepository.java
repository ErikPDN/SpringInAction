package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
