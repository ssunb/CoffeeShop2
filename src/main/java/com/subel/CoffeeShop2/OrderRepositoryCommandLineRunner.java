package com.subel.CoffeeShop2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log =
			LoggerFactory.getLogger(OrderRepositoryCommandLineRunner.class);

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run (String... arg0) throws Exception {
		//Order order = new Order("jill", "fanta");
		//orderRepository.save(order);
		//log.info("new order created: "+ order);
		
	}
}
