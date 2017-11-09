package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Employee;
 
@Controller
public class EmployeeController {
	
	@RequestMapping(value = {"/", "/employee"}, method = RequestMethod.GET)
	public String showEmployeeForm() {
		return "employee";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public @ResponseBody Employee addEmployee(@Valid @RequestBody Employee employee) {
		System.out.println(employee);
		return employee;
	}
}
