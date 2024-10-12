package com.example.demo.mapper;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Mapper
public interface EmployeeMapper {

	
	
    @Mapping(source = "branchId.id", target = "branchId")
	EmployeeDto map(Employee entity);

	
    @Mapping(source = "branchId.id", target = "branchId")
	List<EmployeeDto> map(List<Employee> entities);

	
	//it creates new object
    @Mapping(source = "branchId", target = "branchId.id")
	Employee UnMap(EmployeeDto dto);
	
	
	// this method is used in updating it doesn't not create new object
    @Mapping(source = "branchId", target = "branchId.id")
	Employee UnMap(EmployeeDto dto,@MappingTarget Employee entity);
	
	
}