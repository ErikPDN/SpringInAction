package br.com.erik.spring.tacocloud.data;

import br.com.erik.spring.tacocloud.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
