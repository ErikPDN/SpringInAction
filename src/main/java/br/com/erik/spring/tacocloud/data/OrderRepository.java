package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
