package com.petruz.hexagonalapp.infrastructure.repository;

import com.petruz.hexagonalapp.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
