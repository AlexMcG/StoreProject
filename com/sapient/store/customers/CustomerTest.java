package com.sapient.store.customers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.store.inventory.Item;
import com.sapient.store.inventory.Order;
import com.sapient.store.inventory.OrderDetail;
import com.sapient.store.inventory.Status;
import com.sapient.store.payments.Payment;

public class CustomerTest {
	static Payment testPayment;
	static Item testItem;
	static OrderDetail testOrderDetail;
	static Collection<OrderDetail> testOrderDetails;
	static Order testOrder;
	static Collection<Order> testOrders;
	static Customer testCustomer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testPayment = new Payment();
		testItem = new Item(new Double(0.00), "Description", null, new Double(0.00));
		testOrderDetail = new OrderDetail(new Integer(1), new Double(0.00), null, testItem);
		testItem.setOrderDetail(testOrderDetail);
		testOrderDetails = new ArrayList<OrderDetail>();
		testOrderDetails.add(testOrderDetail);
		testOrder = new Order(new Date(), Status.Ordered, null, testPayment, testOrderDetails);
		testOrderDetail.setOrder(testOrder);
		testOrders= new ArrayList<Order>();
		testOrders.add(testOrder);
		testCustomer = new Customer("Alex McCarten-Gibbs", "123 Fake Street", testOrders);
		testOrder.setCustomer(testCustomer);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testPayment = null;
		testItem = null;
		testOrderDetail = null;
		testOrderDetails = null;
		testOrder = null;
		testOrders = null;
		testCustomer = null;
	}

	@Test
	public final void testCustomer() {
		assertTrue(testCustomer instanceof Customer);
	}

	@Test
	public final void testGetName() {
		String name = testCustomer.getName();
		assertTrue(name instanceof String);
	}

	@Test
	public final void testSetName() {
		testCustomer.setName("Alex");
		assertTrue(testCustomer.getName().equals("Alex"));
	}

	@Test
	public final void testGetAddress() {
		String address = testCustomer.getAddress();
		assertTrue(address instanceof String);	
	}
	@Test
	public final void testSetAddress() {
		testCustomer.setAddress("321 Fake Street");
		assertTrue(testCustomer.getAddress().equals("321 Fake Street"));
	}

	@Test
	public final void testGetOrders() {
		Collection<Order> orders = testCustomer.getOrders();
		assertTrue(orders instanceof Collection);
		for (Order order: orders) {
			assertTrue(order instanceof Order);
		}
	}

	@Test
	public final void testSetOrders() {
		Order order = new Order(new Date(), Status.Delivered, testCustomer, testPayment, testOrderDetails);
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(order);
		testCustomer.setOrders(orders);
		assertTrue(testCustomer.getOrders() == orders);
	}

}
