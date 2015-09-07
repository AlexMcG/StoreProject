package com.sapient.store.inventory;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.store.customers.Customer;
import com.sapient.store.payments.Payment;

public class OrderTest {
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
		testItem = new Item(new Double(1.20), "Description", null, new Double(1.20));
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
	public final void testOrder() {
		assertTrue(testOrder instanceof Order);
	}

	@Test
	public final void testGetDate() {
		Date date = testOrder.getDate();
		assertTrue(date instanceof Date);	
	}

	@Test
	public final void testSetDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2016-05-03");
			testOrder.setDate(date);
			assertTrue(testOrder.getDate().equals(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("SimpleDateFormat ParserException");
		}
	}

	@Test
	public final void testGetStatus() {
		Status status = testOrder.getStatus();
		assertTrue(status instanceof Status);	
	}

	@Test
	public final void testSetStatus() {
		testOrder.setStatus(Status.Shipping);
		assertTrue(testOrder.getStatus().equals(Status.Shipping));
	}

	@Test
	public final void testGetCustomer() {
		Customer customer = testOrder.getCustomer();
		assertTrue(customer instanceof Customer);	
	}

	@Test
	public final void testSetCustomer() {
		Customer customer = new Customer("Test", "123 Fake Street", testOrders);
		testOrder.setCustomer(customer);
		assertTrue(testOrder.getCustomer().equals(customer));
	}

	@Test
	public final void testGetPayment() {
		Payment payment = testOrder.getPayment();
		assertTrue(payment instanceof Payment);	
	}

	@Test
	public final void testSetPayment() {
		Payment payment = new Payment();
		payment.setAmount(2000);
		testOrder.setPayment(payment);
		assertTrue(testOrder.getPayment().equals(payment));
	}

	@Test
	public final void testGetOrderDetails() {
		Collection<OrderDetail> orderDetails = testOrder.getOrderDetails();
		assertTrue(orderDetails instanceof Collection);
		for (OrderDetail orderDetail : orderDetails) {
			assertTrue(orderDetail instanceof OrderDetail);
		}
	}

	@Test
	public final void testSetOrderDetails() {
		Collection<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		testOrderDetails.add(testOrderDetail);
		testOrderDetails.add(testOrderDetail);
		testOrder.setOrderDetails(orderDetails);
		assertTrue(testOrder.getOrderDetails().equals(orderDetails));
	}

	@Test
	public final void testCalcTax() {
		Collection<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		orderDetails.add(testOrderDetail);
		testOrder.setOrderDetails(orderDetails);
		Double tax = testOrder.calcTax();
		Double solution = 1.98;
		assertEquals(tax, solution);
	}

	@Test
	public final void testCalcTotal() {
		Collection<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		orderDetails.add(testOrderDetail);
		testOrder.setOrderDetails(orderDetails);
		Double total = testOrder.calcTotal();
		Double solution = 6.00;
		assertEquals(total, solution);	
	}

	@Test
	public final void testCalcTotalWeight() {
		Collection<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		orderDetails.add(testOrderDetail);
		testOrder.setOrderDetails(orderDetails);
		Double weight = testOrder.calcTotalWeight();
		Double solution = 6.00;
		assertEquals(weight, solution);
	}

}
