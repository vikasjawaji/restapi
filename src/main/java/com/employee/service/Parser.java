package com.employee.service;

import org.springframework.stereotype.Service;

import com.employee.beans.EmployeeEntity;
import com.employee.model.EmployeeModel;
		
@Service
public class Parser {
		public EmployeeEntity parse(EmployeeModel source) {
		return source == null ? null
				: new EmployeeEntity(source.getId(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getDepartment());
	}

	public EmployeeModel parse(EmployeeEntity source) {
		return source == null ? null
				: new EmployeeModel(source.getId(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getDepartment());
	}
}
