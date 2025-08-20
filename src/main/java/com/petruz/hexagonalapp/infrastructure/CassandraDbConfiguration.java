package com.petruz.hexagonalapp.infrastructure;

import com.petruz.hexagonalapp.infrastructure.repository.SpringDataCassandraOrderRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataCassandraOrderRepository.class)
public class CassandraDbConfiguration {
}
