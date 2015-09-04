package com.sapient.store.payments;

import java.util.logging.Logger;

import com.sapient.store.inventory.Order;

public class Payment {
	private double amount=0;
	private Order order;
	static Logger log=Logger.getLogger(Payment.class.getName());
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		if(amount<0){
			log.info("Amount you entered is invalid");
			this.amount=0;
		}else
		{
		this.amount = amount;
		}
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
