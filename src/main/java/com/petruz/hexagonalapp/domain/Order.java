package com.petruz.hexagonalapp.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {

    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal totalPrice;

    public Order(UUID id, Product product) {
        this.id = id;
        this.status = OrderStatus.CREATED;
        this.orderItems = new ArrayList<>(List.of(new OrderItem(product)));
        this.totalPrice = product.getPrice();
    }

    public Order(UUID id) {
        this.id = id;
        this.status = OrderStatus.CREATED;
        this.orderItems = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrderItem(Product product) {
        validateState();
//        validateProduct(product);
        this.orderItems.add(new OrderItem(product));
        this.totalPrice = this.totalPrice.add(product.getPrice());
    }

    public void removeOrder(UUID productId) {
        validateState();
        final OrderItem orderItem = getOrderItem(productId);
        orderItems.remove(orderItem);

        totalPrice = totalPrice.subtract(orderItem.getPrice());
    }

    private void validateState() {
        if (this.status == OrderStatus.COMPLETED) {
            throw new IllegalStateException("Order is already completed");
        }
    }

    private OrderItem getOrderItem(UUID id) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order item not found"));
    }

}
