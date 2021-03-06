package com.sapient.store.inventory;

import java.util.Collection;

public class OrderDetail {
	private Integer quantity;
	private Double taxStatus;
	private Order order;
	private Item item;
	
	public OrderDetail(Integer quantity, Double taxStatus, Order order, Item item) {
		this.quantity = quantity;
		this.taxStatus = taxStatus;
		this.order = order;
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		if (quantity instanceof Integer) {
			this.quantity = quantity;
		}
	}
	public Double getTaxStatus() {
		return taxStatus;
	}
	public void setTaxStatus(Double taxStatus) {
		if (taxStatus instanceof Double) {
			this.taxStatus = taxStatus;
		}
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		if (this.order != null && order instanceof Order) {
			Collection<OrderDetail> orderDetails = this.getOrder().getOrderDetails();
			if (orderDetails.contains(this)) {
				orderDetails.remove(this);
				this.order.setOrderDetails(orderDetails);
			}
		}
		this.order = order;
		if (this.order != null) {
			Collection<OrderDetail> orderDetails = this.getOrder().getOrderDetails();
			orderDetails.add(this);
			this.order.setOrderDetails(orderDetails);
		}
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		if (item == null) {
			this.item = null;
			return;
		} else if (item instanceof Item) {
			if (this.item != null) {
				this.item.setOrderDetail(null);
			}
			this.item = item;
			if (this.item != null) {
				OrderDetail itOrderDetail = this.item.getOrderDetail();
				if (!this.equals(itOrderDetail)) {
					this.item.setOrderDetail(this);
				}
			}
		}
	}
	
	public Double calcSubTotal() {
		return this.getQuantity() * this.getItem().getPrice();
	}
	public Double calcWeight() {
		return this.getQuantity() * this.getItem().getShippingWeight();
	}
}
