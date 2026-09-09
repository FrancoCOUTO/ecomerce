package com.francocouto.ecommerce.service;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.francocouto.ecommerce.dto.OrderDTO;
import com.francocouto.ecommerce.dto.OrderItemDTO;
import com.francocouto.ecommerce.entities.Order;
import com.francocouto.ecommerce.entities.OrderItem;
import com.francocouto.ecommerce.entities.Product;
import com.francocouto.ecommerce.entities.User;
import com.francocouto.ecommerce.enuns.OrderStatus;
import com.francocouto.ecommerce.repositories.OrderItemRepository;
import com.francocouto.ecommerce.repositories.OrderRepository;
import com.francocouto.ecommerce.repositories.ProductRepository;




@Service
public class OrderServise {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserServise userService;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private AuthServisse authServisse;
	
	

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(()-> new ResourceAccessException("Recurso nao encontrado"));
		authServisse.validationSelfOrAdimin(order.getClient().getId());
		return new OrderDTO(order);

	}
	
	
	@Transactional
	public OrderDTO insert (OrderDTO dto) {
		Order order = new Order();
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		User user = userService.authenticated();
		order.setClient(user);
		for(OrderItemDTO itemDto : dto.getItems()) {
			Product product = prodRepo.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(product, order, itemDto.getQuantity(), product.getPrice()) ;
			order.getOrderItem().add(item);
			
		}
		
		orderRepo.save(order);
		orderItemRepository.saveAll(order.getOrderItem());
		return new OrderDTO(order);
		
	}
}

























