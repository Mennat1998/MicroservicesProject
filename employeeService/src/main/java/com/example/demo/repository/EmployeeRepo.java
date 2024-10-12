package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;


public interface EmployeeRepo {

	
	public Optional<Employee> findById (Long id);
	
	public List<Employee> findAll() ;
	
	
	public Employee insert(Employee emp);
	
	public void deleteById(Long id);
	
	public Employee update(Employee emp);
	
	public boolean findByNationalId (String nationalId);
	
}
