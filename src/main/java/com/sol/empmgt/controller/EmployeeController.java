package com.sol.empmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sol.empmgt.model.Employee;
import com.sol.empmgt.repo.IEmployeeRepository;

@RestController
@CrossOrigin(origins="https://localhost:4200")
//@RequestMapping("/employees")
public class EmployeeController
{
	@Autowired
	private IEmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee>getAllEmployees()
	{
List<Employee> list = repo.findAll();
System.out.println("Total employees: " + list.size());
if (!list.isEmpty()) {
    System.out.println(list.get(0));
	}
return list;
	}

}
