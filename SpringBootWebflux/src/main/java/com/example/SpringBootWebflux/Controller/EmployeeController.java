package com.example.SpringBootWebflux.Controller;

import com.example.SpringBootWebflux.DTO.EmployeeDTO;
import com.example.SpringBootWebflux.Model.Employee;
import com.example.SpringBootWebflux.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employeeDTO")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDto){
        return employeeService.saveEmployeeDTO(employeeDto);
    }

    @GetMapping("/employeeDTO")
    @ResponseStatus(value = HttpStatus.FOUND)
    public Flux<EmployeeDTO> getAllEmployess()
    {
        return employeeService.getAllEmployeesDTO();
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public Mono<Employee> getEmployee(@PathVariable String id)
    {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employeeDTO/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<EmployeeDTO> updateEmployeeDTO(@RequestBody EmployeeDTO employeeDTO,@PathVariable String id){
        return employeeService.updateEmployeeDTO(employeeDTO,id);
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void>  deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }
}
