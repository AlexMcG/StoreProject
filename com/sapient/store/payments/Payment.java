package com.sapient.store.payments;
import java.util.logging.Logger;
import org.apache.log4j.*;
import com.sapient.store.inventory.Order;

public class Payment {
	private double amount=0;
	private Order order;
	private static org.apache.log4j.Logger log=LogManager.getLogger(Payment.class);
	String log4jConfPath = "/StoreProject/src/com/sapient/store/payments/log4j.properties";
    
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		 BasicConfigurator.configure();
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
