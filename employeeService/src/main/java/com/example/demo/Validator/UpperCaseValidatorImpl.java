package com.example.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpperCaseValidatorImpl implements ConstraintValidator<UpperCaseValidator,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Check if the value is null or empty 
		// if null it will be invalid
        if (value == null || value.isEmpty()) {
            return false; 
        }
        else
        {
        return value.equals(value.toUpperCase());
        }
	}

}


