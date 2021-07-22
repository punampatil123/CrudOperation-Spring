package com.example.CrudOperation.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudOperation.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
