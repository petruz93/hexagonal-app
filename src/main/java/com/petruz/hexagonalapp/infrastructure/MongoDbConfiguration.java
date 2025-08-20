package com.petruz.hexagonalapp.infrastructure;

import com.petruz.hexagonalapp.infrastructure.repository.SpringDataMongoOrderRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDbConfiguration {
}
