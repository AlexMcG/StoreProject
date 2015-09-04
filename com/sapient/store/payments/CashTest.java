package com.sapient.store.payments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CashTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetCashTendered() {
		Cash cTest = new Cash();
		double expResult = 1000.0;
		cTest.setCashTendered(expResult);
		double actualResult = cTest.getCashTendered();
		assertEquals(expResult, actualResult,0.001);
	}

	@Test
	public void testSetCashTendered() {
		double cashTendered = 1000.0;
		Cash cTest = new Cash();
		cTest.setCashTendered(cashTendered);
		assertEquals(cTest.getCashTendered(),cashTendered,0.001);
	}

}
