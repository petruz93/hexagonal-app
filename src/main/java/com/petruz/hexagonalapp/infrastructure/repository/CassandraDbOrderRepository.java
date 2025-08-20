package com.petruz.hexagonalapp.infrastructure.repository;

import com.petruz.hexagonalapp.domain.Order;
import com.petruz.hexagonalapp.domain.OrderRepository;
import com.petruz.hexagonalapp.infrastructure.repository.cassandra.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CassandraDbOrderRepository implements OrderRepository {

    private final SpringDataCassandraOrderRepository orderRepository;

    public CassandraDbOrderRepository(SpringDataCassandraOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(UUID orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        return orderEntity.map(OrderEntity::toOrder);
    }

    @Override
    public void save(Order order) {
        OrderEntity orderEntity = new OrderEntity(order);
        orderRepository.save(orderEntity);
    }

}
