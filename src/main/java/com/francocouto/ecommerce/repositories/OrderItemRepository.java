package com.francocouto.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francocouto.ecommerce.PK.OrderItemPK;
import com.francocouto.ecommerce.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,  OrderItemPK> {

}
