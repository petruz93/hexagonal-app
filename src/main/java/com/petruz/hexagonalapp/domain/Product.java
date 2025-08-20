package com.petruz.hexagonalapp.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Product {

    private UUID id;
    private String name;
    private BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(UUID id, BigDecimal price) {
        this.id = id;
        this.name = "UNKNOWN";
        this.price = price;
    }

}
