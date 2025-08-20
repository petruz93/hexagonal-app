package com.petruz.hexagonalapp.infrastructure.repository.cassandra;

import com.petruz.hexagonalapp.domain.OrderItem;
import com.petruz.hexagonalapp.domain.Product;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.math.BigDecimal;
import java.util.UUID;

@UserDefinedType("order_item")
@Data
public class OrderItemEntity {

    @Column("product_id")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID productId;

    @Column("price")
    @CassandraType(type = CassandraType.Name.DECIMAL)
    private BigDecimal price;

    public OrderItemEntity(OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.price = orderItem.getPrice();
    }

    public OrderItem toOrderItem() {
        var product = new Product(this.productId, null, this.price);
        return new OrderItem(product);
    }
}
