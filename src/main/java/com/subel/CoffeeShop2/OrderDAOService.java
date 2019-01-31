package com.subel.CoffeeShop2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrderDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Order order) {
		entityManager.persist(order);
		return order.getId();
	}
}
