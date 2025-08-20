package com.petruz.hexagonalapp.infrastructure.repository.cassandra;

import com.petruz.hexagonalapp.domain.Order;
import com.petruz.hexagonalapp.domain.Product;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table("orders")
@Data
public class OrderEntity {

    @PrimaryKey
    private UUID id;

    @Column("status")
    private String status;

    @Column("order_items")
    @CassandraType(type = Name.LIST, typeArguments = Name.UDT, userTypeName = "order_item")
    private List<OrderItemEntity> orderItems;

    @Column("price")
    private BigDecimal price;

    public OrderEntity(Order order) {
        this.id = order.getId();
        this.status = order.getStatus().name();
        this.orderItems = order.getOrderItems().stream().map(OrderItemEntity::new).toList();
        this.price = order.getTotalPrice();
    }

    public Order toOrder() {
        Order order = new Order(this.id);
        orderItems.forEach(orderItemEntity ->
            order.addOrderItem(new Product(orderItemEntity.getProductId(), null, orderItemEntity.getPrice()))
        );
        return order;
    }

}
