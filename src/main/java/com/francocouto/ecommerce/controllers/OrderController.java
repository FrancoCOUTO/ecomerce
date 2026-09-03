package com.francocouto.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francocouto.ecommerce.dto.OrderDTO;
import com.francocouto.ecommerce.service.OrderServise;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderServise orderService;
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById (@PathVariable Long id){
		OrderDTO dto =  orderService.findById(id);
		return ResponseEntity.ok(dto);
		
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<OrderDTO> insert (@RequestBody OrderDTO dto){
		OrderDTO orderDto = orderService.insert(dto);
		return ResponseEntity.ok(orderDto);
		
	}
	

}
