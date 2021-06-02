package com.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.beans.EmployeeEntity;
import com.employee.dao.EmployeeDAO;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeModel;

@Service
@Transactional

public class EmployeeService implements IEmployeeService{

	@Autowired
	private EmployeeDAO dao;
	private Parser parser;

	@Override
	public EmployeeModel addEmployee( EmployeeModel employ) throws EmployeeException {
		if (!dao.findById(employ.getId()).isPresent()) {
			return parser.parse(dao.save(parser.parse(employ)));

		} else
			throw new EmployeeException("Employee already exist");
	}

	@Override
	public List<EmployeeEntity> displayEmployees() {
		
		return dao.findAll();
	}

	@Override
	public boolean deleteById(int empId) throws EmployeeException {
		if (dao.findById(empId).isPresent()) {
			dao.deleteById(empId);
			return true;
		} else
			throw new EmployeeException("Employee record does not exist");
	}

	@Override
	public EmployeeEntity searchById(int id) throws EmployeeException {
		if (dao.findById(id).isPresent())
			return dao.findById(id).get();
		else
			throw new EmployeeException("Employee record does not exist");
	}

	@Override
	public EmployeeEntity updateEmployee(int id, EmployeeEntity employ) throws EmployeeException {
		if (dao.findById(id).isPresent())
			return dao.saveAndFlush(employ);
		else
			throw new EmployeeException("Employee record does not exist");
		}

}
