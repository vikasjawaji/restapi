package com.employee.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String department;	
	
}
