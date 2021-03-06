package com.sapient.store.payments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sapient.store.inventory.Order;

public class PaymentTest {
    Payment payment;
    Order order;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAmount() {
		double amount=100.00;
	    payment=new Payment();
	    payment.setAmount(amount);
	    double actual=payment.getAmount();
	    assertEquals(amount, actual, 0);
	}
	@Test
	public void negativeTestAmount() {
		double amount=-100.00;
	    payment=new Payment();
	    payment.setAmount(amount);
	    double actual=payment.getAmount();
	    assertEquals(0, actual, 0);
	}

	@Test
	public void testOrder() {
		  payment=new Payment();
	      order=new Order();
	      payment.setOrder(order);
	      Order actual=payment.getOrder();
	      assertEquals(order, actual);
	}

}
