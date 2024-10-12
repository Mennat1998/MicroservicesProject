package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private  EmployeeRepo employeeRepo ;
	
	public Employee findById(Long id)
	{
		//findById return optional 
		return employeeRepo.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee insert(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepo.insert(emp);
	}

	@Override
	public Employee Update(Employee emp) {
		
			return employeeRepo.update(emp);
	}

	@Override
	public void deleteById(Long id) {
		Employee currentEmp= employeeRepo.findById(id).orElse(null);
		if(currentEmp !=null)
		{
			employeeRepo.deleteById(id);
		}
	}
	
}
