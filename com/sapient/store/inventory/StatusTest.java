package com.sapient.store.inventory;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StatusTest {
	static Status status;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		status = Status.Ordered;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		status = null;
	}

	@Test
	public final void testToString() {
		assertTrue(status.Ordered.toString().equals("your request has been processed."));
		assertTrue(status.Shipping.toString().equals("Your purchase is currently shipping"));
		assertTrue(status.Delivered.toString().equals("Your purchase has been delivered"));
	}

}
