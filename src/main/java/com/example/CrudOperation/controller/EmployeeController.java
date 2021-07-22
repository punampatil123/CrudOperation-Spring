package com.example.CrudOperation.controller;

	
	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOperation.model.Employee;
import com.example.CrudOperation.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin("http://localhost:4200")

public class EmployeeController {
	@Autowired
	private EmployeeService empService;
//@RequestMapping("/")
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeeList = empService.getEmployeeList();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
		Employee employee = empService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<String> addNewEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return new ResponseEntity<>( "datasaved",HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployees(@PathVariable("id") long id) {
		empService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		empService.updateEmployeeTable(emp);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

