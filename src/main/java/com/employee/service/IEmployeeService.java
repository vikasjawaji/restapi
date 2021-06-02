package com.employee.service;

import java.util.List;

import com.employee.beans.EmployeeEntity;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeModel;

public interface IEmployeeService {

	public EmployeeModel addEmployee(EmployeeModel employ) throws EmployeeException ;
	public List<EmployeeEntity> displayEmployees() ;
	public boolean deleteById(int empId) throws EmployeeException;
	public EmployeeEntity searchById(int id)  throws EmployeeException;
	public EmployeeEntity updateEmployee(int id,EmployeeEntity employ)  throws EmployeeException;
}
