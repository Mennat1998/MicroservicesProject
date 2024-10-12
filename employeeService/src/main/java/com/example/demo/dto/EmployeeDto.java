package com.example.demo.dto;

import com.example.demo.Validator.UniqueNationalId;
import com.example.demo.Validator.UpperCaseValidator;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

	private Long id ;
	
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{NameValidator}")
    @UpperCaseValidator
    private String name ;	
    
	@Column(unique = true)
    @UniqueNationalId
	@Size(min = 14, max = 14, message = "{NationalIdLetters}")
	private String NationalId ;
		
	private String age ;

	
	private Long branchId ;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalId() {
		return NationalId;
	}

	public void setNationalId(String nationalId) {
		NationalId = nationalId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	
	
}
