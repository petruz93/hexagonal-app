package com.petruz.hexagonalapp.domain;

import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(Product product) {
        Order order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void completeOrder(UUID orderId) {
        Order order = getOrder(orderId);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void addProduct(UUID orderId, Product product) {
        Order order = getOrder(orderId);
        order.addOrderItem(product);

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(UUID orderId, UUID productId) {
        Order order = getOrder(orderId);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

}
