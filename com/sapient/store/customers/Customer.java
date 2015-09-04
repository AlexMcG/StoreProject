package com.sapient.store.customers;

import java.util.Collection;

import com.sapient.store.inventory.Order;

public class Customer {
	private String name;
	private String address;
	private Collection<Order> orders;
	
	public Customer(String name, String address, Collection<Order> order) {
		this.name = name;
		this.address = address;
		this.orders = order;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Collection<Order> getOrders() {
		return this.orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
}
