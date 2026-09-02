package com.francocouto.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francocouto.ecommerce.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
