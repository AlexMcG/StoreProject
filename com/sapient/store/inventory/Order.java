package com.sapient.store.inventory;

import java.util.Collection;
import java.util.Date;

import com.sapient.store.customers.Customer;
import com.sapient.store.payments.Payment;

public class Order {
	private Date date;
	private Status status;
	private Customer customer;
	private Payment payment;
	private Collection<OrderDetail> orderDetails;
	
	public Order(Date date, Status status, Customer customer, Payment payment,
			Collection<OrderDetail> orderDetails) {
		this.date = date;
		this.status = status;
		this.customer = customer;
		this.payment = payment;
		this.orderDetails = orderDetails;
	}
	
	public Order() {
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		if (date instanceof Date) {
			this.date = date;
		}
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		if (status instanceof Status) {
			this.status = status;
		}
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		if (!(customer instanceof Customer)) {
			return;
		}
		if (this.customer != null) {
			Collection<Order> orders = this.getCustomer().getOrders();
			if (orders.contains(this)) {
				orders.remove(this);
				this.getCustomer().setOrders(orders);
			}
		}
		this.customer = customer;
		if (this.customer != null) {
			Collection<Order> orders = this.getCustomer().getOrders();
			orders.add(this);
			this.getCustomer().setOrders(orders);
		}
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		if (payment instanceof Payment) {
			this.payment = payment;
		}
	}
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		if (orderDetails instanceof Collection) {
			this.orderDetails = orderDetails;	
		}
	}
	
	public Double calcTax() {
		Double total = 0.00;
		for (OrderDetail orderDetail : orderDetails) {
			total += (orderDetail.calcSubTotal() * orderDetail.getTaxStatus());
		}
		return total;
	}
	public Double calcTotal() {
		Double total = 0.00;
		for (OrderDetail orderDetail : orderDetails) {
			total += orderDetail.calcSubTotal();
		}
		return total;
	}
	public Double calcTotalWeight() {
		Double total = 0.00;
		for (OrderDetail orderDetail : orderDetails) {
			total += orderDetail.calcWeight();
		}
		return total;
	}
}
