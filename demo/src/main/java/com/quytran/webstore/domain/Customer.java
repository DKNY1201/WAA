package com.quytran.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 7482752217723676267L;
	String customerId;
	String name;
	String address;
	long noOfOrdersMade;
	
	public Customer() {}
	
	public Customer(String customerId, String name, String address, long noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
