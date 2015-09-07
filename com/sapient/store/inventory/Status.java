package com.sapient.store.inventory;

public enum Status {
	Ordered("your request has been processed."),
	Shipping("Your purchase is currently shipping"),
	Delivered("Your purchase has been delivered");
	
	private final String message;
	private Status(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		if (message instanceof String) {
			return this.message;
		}
		return "";
	}
}
