package com.petruz.hexagonalapp.infrastructure.repository;

import com.petruz.hexagonalapp.infrastructure.repository.cassandra.OrderEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface SpringDataCassandraOrderRepository extends CassandraRepository<OrderEntity, UUID> {
}
