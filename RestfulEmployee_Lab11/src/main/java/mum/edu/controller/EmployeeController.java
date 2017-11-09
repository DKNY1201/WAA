package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mum.edu.domain.Employee;
 
@RestController
public class EmployeeController {
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		System.out.println(employee);
		return employee;
	}
}
