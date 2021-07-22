

package com.example.CrudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudOperation.Exception.EmployeeNotFoundException;

import com.example.CrudOperation.Repository.EmployeeRepository;
import com.example.CrudOperation.model.Employee;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getEmployeeList(){
		return (List<Employee>) empRepo.findAll();
	}
	
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public void deleteEmployeeById(long id) {
		empRepo.deleteById(id);
	}

	public void updateEmployeeTable(Employee emp) {
		empRepo.findById(emp.getId()).orElseThrow(() -> new EmployeeNotFoundException("Employee not found by this id : " + emp.getId()));
		empRepo.save(emp);
	}

	public Employee getEmployeeById(long id) {
		return empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
	}

}