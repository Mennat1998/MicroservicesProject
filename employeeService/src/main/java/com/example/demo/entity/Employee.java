package com.example.demo.entity;

import com.example.demo.Validator.UniqueNationalId;
import com.example.demo.Validator.UpperCaseValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class Employee {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{NameValidator}")
    @UpperCaseValidator
	private String name ;
	
	@Column(unique = true)
    @UniqueNationalId
	@Size(min = 14, max = 14, message = "{NationalIdLetters}")
	private String NationalId ;
	
	
	private String age ;
	
	
    @ManyToOne
    @JoinColumn(name ="branchId")
    private Branch branchId;


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


	public Branch getBranchId() {
		return branchId;
	}


	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}



	
}
