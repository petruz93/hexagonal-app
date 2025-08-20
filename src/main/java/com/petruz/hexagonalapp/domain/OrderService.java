package com.petruz.hexagonalapp.domain;

import java.util.UUID;

public interface OrderService {

    UUID createOrder(Product product);
    void completeOrder(UUID orderId);
    void addProduct(UUID orderId, Product product);
    void deleteProduct(UUID orderId, UUID productId);

}
