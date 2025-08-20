package com.petruz.hexagonalapp.infrastructure.repository;

import com.petruz.hexagonalapp.domain.Order;
import com.petruz.hexagonalapp.domain.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDbOrderRepository implements OrderRepository {

    private final SpringDataMongoOrderRepository orderRepository;

    public MongoDbOrderRepository(SpringDataMongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(UUID orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

}
