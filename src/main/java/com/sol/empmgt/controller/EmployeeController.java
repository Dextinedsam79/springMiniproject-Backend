package com.sol.empmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sol.empmgt.exception.EmployeeNotFoundException;
import com.sol.empmgt.model.Employee;
import com.sol.empmgt.repo.IEmployeeRepository;

@RestController
@CrossOrigin(origins="*")
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
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return repo.save(employee);
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId)
	{
		Employee employee = repo.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Integer empId, @RequestBody Employee employeeDetails)
	{
		Employee employee = repo.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setEmpDesignation(employeeDetails.getEmpDesignation());
		employee.setEmpSalary(employeeDetails.getEmpSalary());
		repo.save(employee);
		return ResponseEntity.ok(employee);
	}

}
