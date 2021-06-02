package com.employee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.beans.EmployeeEntity;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/getEmployees")
	public ResponseEntity<List<EmployeeEntity>> getEmployees() {
		return new ResponseEntity<List<EmployeeEntity>>(service.displayEmployees(), HttpStatus.OK);

	}

	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody(required = false)
 EmployeeModel employ) throws EmployeeException {
		return new ResponseEntity<EmployeeModel>(service.addEmployee(employ), HttpStatus.OK);

	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeEntity> searchEmployee(@PathVariable int id) throws EmployeeException {

		return new ResponseEntity<EmployeeEntity>(service.searchById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws EmployeeException {
		return new ResponseEntity<Boolean>(service.deleteById(id), HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeEntity> addEmployee(@PathVariable int id, @RequestBody EmployeeEntity employ)
			throws EmployeeException {
		return new ResponseEntity<EmployeeEntity>(service.updateEmployee(id, employ), HttpStatus.OK);

	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Object> handleRuntimeException(HttpServletRequest request, Exception ex) {
		System.out.println("RuntimeException Occured:: URL=" + request.getRequestURL() + " raised " + ex);
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
