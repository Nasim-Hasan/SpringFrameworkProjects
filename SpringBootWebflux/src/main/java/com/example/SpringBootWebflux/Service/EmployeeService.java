package com.example.SpringBootWebflux.Service;

import com.example.SpringBootWebflux.DTO.EmployeeDTO;
import com.example.SpringBootWebflux.Mapper.EmployeeMapper;
import com.example.SpringBootWebflux.Model.Employee;
import com.example.SpringBootWebflux.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<EmployeeDTO> saveEmployeeDTO(EmployeeDTO employeeDto)
    {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }
    public Mono<Employee> getEmployee(String employeeID)
    {
         Mono<Employee> empmono = employeeRepository.findById(employeeID);
         return empmono;
    }
    public Flux<EmployeeDTO> getAllEmployeesDTO()
    {
        Flux<Employee> employeeFlux  = employeeRepository.findAll();
        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }
    public Mono<EmployeeDTO> updateEmployeeDTO(EmployeeDTO employeeDTO,String employeeId)
    {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);
        Mono<Boolean> employeeMonoPresent = employeeMono.hasElement();

        if(employeeMonoPresent.share().block()) {
            return employeeMono.flatMap((existingEmployee) -> {
                existingEmployee.setFirstName(employeeDTO.getFirstName());
                existingEmployee.setLastName(employeeDTO.getLastName());
                existingEmployee.setEmail(employeeDTO.getEmail());
                return employeeRepository.save(existingEmployee);
            }).map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));
        }
        else{
            Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
            Mono<Employee> savedEmployee = employeeRepository.save(employee);
            return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
        }
    }
    public Mono<Void> deleteEmployee(String employeeID)
    {
        return employeeRepository.deleteById(employeeID);
    }
}
