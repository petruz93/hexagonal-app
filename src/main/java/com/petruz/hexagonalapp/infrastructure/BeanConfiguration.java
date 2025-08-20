package com.petruz.hexagonalapp.infrastructure;

import com.petruz.hexagonalapp.domain.DomainOrderService;
import com.petruz.hexagonalapp.domain.OrderRepository;
import com.petruz.hexagonalapp.domain.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }

}
