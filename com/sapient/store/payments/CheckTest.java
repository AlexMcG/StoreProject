package com.sapient.store.payments;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckTest {
	private final static Map<String, String> bankDetails = new HashMap<String, String>();

	Check check;

	@Before
	public void setUp() throws Exception {
		check = new Check();
		bankDetails.put("HDFCBank", "HDFC0001098");
		bankDetails.put("ICICI Bank", "ICICI000000");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSetNametest() {
		String expected = "HDFCBank";
		String actual = null;
		check = new Check();
		check.setName("HDFCBank");
		actual = check.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void getSetBankIdtest() {
		String expected = "HDFC0001098";
		String actual = null;
		check = new Check();
		check.setBankID("HDFC0001098");
		actual = check.getBankID();
		assertEquals(expected, actual);
	}

	@Test
	public void authorizedTest() {
		check = new Check();
		check.setBankID("HDFC0001098");
		check.setName("HDFCBank");
		String actual = null;
		Iterator <Map.Entry<String,String>>mapIterator=bankDetails.entrySet().iterator();
		while(mapIterator.hasNext()){
		      Map.Entry<String, String>entry= mapIterator.next();
		      String name=entry.getKey();
		      String bankid=entry.getValue();
		      if(entry.getKey()==check.getName()&&entry.getValue()==check.getBankID()){
		    	  actual=check.authorized("Check Authorized");
		      }
		      else{
		    	  actual=check.authorized("Check Not Authorized");
		      }
				
			}
		String expected = "Check Authorized";
		
		
		//actual = check.authorized();
		assertEquals(expected, actual);
	}
	@Test
	public void notAuthorizedTest() {
		check = new Check();
		check.setBankID("HDFC0001008");
		check.setName("HDFCBank");
		String actual = null;
		Iterator <Map.Entry<String,String>>mapIterator=bankDetails.entrySet().iterator();
		while(mapIterator.hasNext()){
		      Map.Entry<String, String>entry= mapIterator.next();
		      String name=entry.getKey();
		      String bankid=entry.getValue();
		      if(entry.getKey()==check.getName()&&entry.getValue()==check.getBankID()){
		    	  actual=check.authorized("Check Authorized");
		      }
		      else{
		    	  actual=check.authorized("Check Not Authorized");
		      }
				
			}
		String expected = "Check Not Authorized";
		
		
		//actual = check.authorized();
		assertEquals(expected, actual);
	}
}
