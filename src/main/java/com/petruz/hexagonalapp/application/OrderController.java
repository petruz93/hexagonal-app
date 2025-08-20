package com.petruz.hexagonalapp.application;

import com.petruz.hexagonalapp.application.dto.AddProductRequest;
import com.petruz.hexagonalapp.application.dto.CreateOrderRequest;
import com.petruz.hexagonalapp.application.dto.CreateOrderResponse;
import com.petruz.hexagonalapp.domain.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        var product = request.product();
        var orderId = orderService.createOrder(product);

        return new CreateOrderResponse(orderId);
    }

    @PostMapping("/{order-id}/products")
    public void addProduct(@PathVariable("order-id") UUID orderId, @RequestBody AddProductRequest request) {
        var product = request.product();
        orderService.addProduct(orderId, product);
    }

    @DeleteMapping("/{order-id}/products/{product-id}")
    public void deleteProduct(@PathVariable("order-id") UUID orderId, @PathVariable("product-id") UUID productId) {
        orderService.deleteProduct(orderId, productId);
    }

    @PostMapping("/{order-id}/complete")
    public void completeOrder(@PathVariable("order-id") UUID orderId) {
        orderService.completeOrder(orderId);
    }

}
