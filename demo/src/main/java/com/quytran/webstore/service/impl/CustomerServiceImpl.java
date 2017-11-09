package com.quytran.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quytran.webstore.domain.Customer;
import com.quytran.webstore.domain.repository.CustomerRepository;
import com.quytran.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
//		customer.setNoOfOrdersMade(0);
		customerRepository.addCustomer(customer);
	}

}
