package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.error.RecoredNotFoundExecption;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private  EmployeeMapper employeeMapper;
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return ("Hello from Employee Service");

	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
		Employee emp = employeeService.findById(id);

		EmployeeDto dto = employeeMapper.map(emp);
		if(dto == null)
		{
			throw new RecoredNotFoundExecption("Record doesn't exsist");}
		else
		{
		return ResponseEntity.ok(dto);
		}
	}
	
	
	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> findAll() {
		
		List<Employee> emps = employeeService.findAll();

		List<EmployeeDto> dtos = employeeMapper.map(emps);
		return ResponseEntity.ok(dtos);
	}
	
	
	
	@PostMapping()
	public ResponseEntity<EmployeeDto> insert(@RequestBody @Valid EmployeeDto empdto) {
		Employee emp=employeeMapper.UnMap(empdto);
		Employee empInserted= employeeService.insert(emp);

		EmployeeDto dto = employeeMapper.map(empInserted);
		return ResponseEntity.ok(dto);
	}

	@PutMapping()
	public ResponseEntity<EmployeeDto> update(@RequestBody @Valid EmployeeDto empdto) {
		Employee empSaved=employeeService.findById(empdto.getId());
		Employee emp=employeeMapper.UnMap(empdto,empSaved);
		Employee empUpdated= employeeService.Update(emp);
		
		EmployeeDto dto = employeeMapper.map(empUpdated);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		 employeeService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	
	
	
	
	

}
