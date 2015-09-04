package com.sapient.store.inventory;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.store.customers.Customer;
import com.sapient.store.payments.Payment;

public class OrderDetailTest {
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
		testItem = new Item(new Double(1.2), "Description", null, new Double(1.2));
		testOrderDetail = new OrderDetail(new Integer(5), new Double(0.33), null, testItem);
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
	public final void testOrderDetail() {
		assertTrue(testOrderDetail instanceof OrderDetail);
	}

	@Test
	public final void testGetQuantity() {
		Integer quantity = testOrderDetail.getQuantity();
		assertTrue(quantity instanceof Integer);	
	}

	@Test
	public final void testSetQuantity() {
		testOrderDetail.setQuantity(55);
		assertTrue(testOrderDetail.getQuantity() == 55);
	}

	@Test
	public final void testGetTaxStatus() {
		Double taxStatus = testOrderDetail.getTaxStatus();
		assertTrue(taxStatus instanceof Double);	
	}

	@Test
	public final void testSetTaxStatus() {
		testOrderDetail.setTaxStatus(.33);
		assertTrue(testOrderDetail.getTaxStatus().equals(.33));
	}

	@Test
	public final void testGetOrder() {
		Order order = testOrderDetail.getOrder();
		assertTrue(order instanceof Order);
	}

	@Test
	public final void testSetOrder() {
		Order order = new Order(new Date(), Status.Delivered, testCustomer, testPayment, testOrderDetails);
		testOrderDetail.setOrder(order);
		assertTrue(testOrderDetail.getOrder().equals(order));
	}

	@Test
	public final void testGetItem() {
		Item item = testOrderDetail.getItem();
		assertTrue(item instanceof Item);
	}
	
	@Test
	public final void testSetItem() {
		Item item = new Item(new Double(0.00), "Test description", null, new Double(15.491));
		testOrderDetail.setItem(item);
		assertTrue(testOrderDetail.getItem().equals(item));	
	}
	
	@Test
	public final void testCalcSubTotal() {
		testOrderDetail.setQuantity(5);
		testOrderDetail.getItem().setPrice(1.2);
		Double subTotal = testOrderDetail.calcSubTotal();
		assertEquals(subTotal, (Double) 6.00);
	}

	@Test
	public final void testCalcWeight() {
		testOrderDetail.setQuantity(5);
		testOrderDetail.getItem().setShippingWeight(1.2);
		Double weight = testOrderDetail.calcWeight();
		assertEquals(weight, (Double) 6.00);	
	}

}
