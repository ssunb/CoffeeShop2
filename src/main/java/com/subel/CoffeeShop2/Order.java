package com.subel.CoffeeShop2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Table - Order

@Entity
@Table(name="table_order")
public class Order {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String drink;
	
	
	protected Order() {
		
	}
	
	public Order(String name, String drink) {	
		super();
		this.name = name;
		this.drink = drink;
	};
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDrink() {
		return drink;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", drink=" + drink + "]";
	}

	
}
