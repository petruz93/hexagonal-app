package com.petruz.hexagonalapp.application;

import com.petruz.hexagonalapp.domain.OrderService;
import com.petruz.hexagonalapp.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@Slf4j
public class CliOrderController {

    private final OrderService orderService;

    public CliOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createCompleteOrder() {
        log.info("<<Create complete order>>");
        UUID orderId = createOrder();
        orderService.completeOrder(orderId);
    }

    public void createIncompleteOrder() {
        log.info("<<Create incomplete order>>");
        UUID orderId = createOrder();
    }

    private UUID createOrder() {
        log.debug("Placing a new order with two products");
        Product mobilePhone = new Product(UUID.randomUUID(), "mobile", BigDecimal.valueOf(200));
        Product razor = new Product(UUID.randomUUID(), "razor", BigDecimal.valueOf(50));

        log.debug("Creating order with mobile phone");
        UUID orderId = orderService.createOrder(mobilePhone);

        log.debug("Adding a razor to the order");
        orderService.addProduct(orderId, razor);

        return orderId;
    }

}
