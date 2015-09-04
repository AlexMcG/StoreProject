package com.sapient.store.inventory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.store.customers.Customer;
import com.sapient.store.payments.Payment;

public class ItemTest {
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
	public final void testItem() {
		assertTrue(testItem instanceof Item);
	}

	@Test
	public final void testGetShippingWeight() {
		Double shippingWeight = testItem.getShippingWeight();
		assertTrue(shippingWeight instanceof Double);
	}

	@Test
	public final void testSetShippingWeight() {
		testItem.setShippingWeight(15.00);
		assertTrue(testItem.getShippingWeight().equals(15.00));
	}

	@Test
	public final void testGetDescription() {
		String description = testItem.getDescription();
		assertTrue(description instanceof String);
	}

	@Test
	public final void testSetDescription() {
		testItem.setDescription("test description");
		assertTrue(testItem.getDescription().equals("test description"));
	}

	@Test
	public final void testGetOrderDetail() {
		OrderDetail orderDetail = testItem.getOrderDetail();
		assertTrue(orderDetail instanceof OrderDetail);
	}

	@Test
	public final void testSetOrderDetail() {
		OrderDetail testOrderDetail = new OrderDetail(new Integer(5), new Double(0.00), testOrder, testItem);
		testItem.setOrderDetail(testOrderDetail);
		assertTrue(testItem.getOrderDetail().equals(testOrderDetail));
	}

	@Test
	public final void testGetPrice() {
		Double price = testItem.getPrice();
		assertTrue(price instanceof Double);
	}

	@Test
	public final void testSetPrice() {
		testItem.setPrice(100.00);
		assertTrue(testItem.getPrice().equals(100.00));
	}

	@Test
	public final void testGetPriceforQuantity() {
		Double priceForQuantity = testItem.getPriceforQuantity();
		assertTrue(priceForQuantity instanceof Double);
	}

	@Test
	public final void testGetWeight() {
		Double weight = testItem.getWeight();
		assertTrue(weight instanceof Double);
	}

}
