package com.example.demo.Validator;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UpperCaseValidatorImpl.class})
public @interface UpperCaseValidator {

	
	String message() default "{jakarta.validation.constraints.name.upperCase.message}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
}
