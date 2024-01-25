package com.example.SpringBootWebflux.Repository;

import com.example.SpringBootWebflux.Model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
