package com.petruz.hexagonalapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DomainOrderServiceUnitTest {

    private OrderRepository orderRepository;
    private DomainOrderService service;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        service = new DomainOrderService(orderRepository);
    }

    @Test
    void shouldCreateOrder_thenSaveIt() {
        final Product product = new Product(UUID.randomUUID(), "productName", BigDecimal.TEN);
        final UUID orderId = service.createOrder(product);

        verify(orderRepository).save(any(Order.class));
        assertNotNull(orderId);
    }

}
