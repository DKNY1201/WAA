package com.quytran.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quytran.webstore.domain.Customer;
import com.quytran.webstore.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public String customerAddForm(@ModelAttribute("newCustomer") Customer customer, Model model) {
		return "addCustomer";
	}
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("newCustomer") Customer customer, Model model) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
}
