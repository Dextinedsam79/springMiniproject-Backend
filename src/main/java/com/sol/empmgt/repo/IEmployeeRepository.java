package com.sol.empmgt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sol.empmgt.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{
	

}
