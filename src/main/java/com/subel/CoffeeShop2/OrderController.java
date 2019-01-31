package com.subel.CoffeeShop2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/")
	public String hello() {
		return "Hello from Order!";
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderRepository.findAll();	
	}
	
	@GetMapping("/order/{id}")
	public Optional<Order> getOrder(@PathVariable long id) {
		return orderRepository.findById(id);
	}
	
	@PostMapping("/order")
	public Order saveOrder(@RequestBody Order newOrder) {
		orderRepository.save(newOrder);
		return newOrder;
	}
	
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable long id) {
		orderRepository.deleteById(id);
	}
	
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order newOrder) {
		orderRepository.save(newOrder);
		return newOrder;
	}
	
	
}
