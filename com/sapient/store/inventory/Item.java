package com.sapient.store.inventory;

public class Item {
	private Double shippingWeight;
	private String description;
	private OrderDetail orderDetail;
	private Double price;
	
	public Item(Double shippingWeight, String description,
			OrderDetail orderDetail, Double price) {
		this.shippingWeight = shippingWeight;
		this.description = description;
		this.orderDetail = orderDetail;
		this.price = price;
	}
	
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		if (orderDetail == null) {
			this.orderDetail = null;
		} else {
			if (this.orderDetail != null) {
				this.orderDetail.setItem(null);
			}
			this.orderDetail = orderDetail;
			if (this.orderDetail != null) {
				Item odItem = this.orderDetail.getItem();
				if (!this.equals(odItem)) {
					this.orderDetail.setItem(this);
				}
			}
		}
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPriceforQuantity() {
		return this.price;
	}
	public Double getWeight() {
		return this.getShippingWeight();
	}
}
