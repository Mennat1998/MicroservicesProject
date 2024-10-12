package com.example.demo.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.EmployeeRepo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNationalIdImpl implements ConstraintValidator<UniqueNationalId,String>{

	
	@Autowired
    private EmployeeRepo employeeRepo; 

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; 
        }

        return !employeeRepo.findByNationalId(value);
    }
}
