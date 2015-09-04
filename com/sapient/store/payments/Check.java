package com.sapient.store.payments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Check extends Payment implements Authorization{
	private static String name=null;
	private static String bankID=null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	
	@Override
	public String authorized(String message) {
		 
		// TODO Auto-generated method stub
		
		
		return message;
		
	}
	
}
