package com.example.SpringBootWebflux.Controller;

import com.example.SpringBootWebflux.DTO.EmployeeDTO;
import com.example.SpringBootWebflux.Model.Employee;
import com.example.SpringBootWebflux.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
@WebFluxTest(controllers = EmployeeController.class)
//@Import(EmployeeService.class)
@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {
    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private WebTestClient webClient;
    /*@MockBean
    private EmployeeRepository employeeRepository;*/

     @Test
    public void testCreatingEmployee(){
         EmployeeDTO employee = new EmployeeDTO();
         employee.setId("ABC567");
         employee.setFirstName("Nasim");
         employee.setLastName("Hasan");
         employee.setEmail("nasim.hasan@bjitgroup.com");

         //Mockito.when(repository.save(employee)).thenReturn(Mono.just(employee));

         Mockito.when(employeeService.saveEmployeeDTO(any(EmployeeDTO.class)))
                 .thenReturn(Mono.just(employee));

         WebTestClient.ResponseSpec response = webClient.post().uri("/employeeDTO")
                 .contentType(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON)
                 .body(Mono.just(employee), EmployeeDTO.class)
                 .exchange();

         // then - verify the result or output using assert statements
         response.expectStatus().isCreated()
                 .expectBody()
                 .consumeWith(System.out::println)
                 .jsonPath("$.firstName").isEqualTo(employee.getFirstName())
                 .jsonPath("$.lastName").isEqualTo(employee.getLastName())
                 .jsonPath("$.email").isEqualTo(employee.getEmail());

        /* webClient.post()
                 .uri("/employeeDTO")
                 .contentType(MediaType.APPLICATION_JSON)
                 .body(BodyInserters.fromObject(EmployeeMapper.mapToEmployeeDto(employee)))
                 .exchange()
                 .expectStatus().isCreated();

         Mockito.verify(repository, times(1)).save(employee);*/

}
    @Test
    public void testGetEmployee(){
        String employeeId = "ABC123";
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Cena");
        employee.setEmail("john.cena@gmail.com");

        Mockito.when(employeeService.getEmployee(employeeId))
                .thenReturn(Mono.just(employee));

        // when - action or behaviour that we are going test
        WebTestClient.ResponseSpec response = webClient.get()
                .uri("/employee/{id}", Collections.singletonMap("id", employeeId))
                .exchange();
        // then - verify the result or output using assert statements
        response.expectStatus().isFound()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employee.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employee.getLastName())
                .jsonPath("$.email").isEqualTo(employee.getEmail());
}
    @Test
    public void testGetAllEmployees(){
         EmployeeDTO employee1 = new EmployeeDTO();
         employee1.setId("ABC189");
         employee1.setFirstName("Riku");
         employee1.setLastName("Watanabe");
         employee1.setEmail("riku.watanabe@bjitgroup.com");

        EmployeeDTO employee2 = new EmployeeDTO();
        employee2.setId("BKE986");
        employee2.setFirstName("Toshiyuki");
        employee2.setLastName("Koitabashi");
        employee2.setEmail("toshiyuki.koitabashi@bjitgroup.com");

        List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
        employeeDTOList.add(employee1);
        employeeDTOList.add(employee2);

        Flux<EmployeeDTO> employeeDTOFlux = Flux.fromIterable(employeeDTOList);

        Mockito.when(employeeService.getAllEmployeesDTO())
                .thenReturn(employeeDTOFlux);

        // when - action or behaviour that we are going test
        WebTestClient.ResponseSpec response = webClient.get().uri("/employeeDTO")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        // then - verify the result or output using assert statements
        response.expectStatus().isFound()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(EmployeeDTO.class);
     }

     @Test
    public void testUpdateEmployee(){
         String employeeId = "JHK478";
         EmployeeDTO employee = new EmployeeDTO();
         employee.setFirstName("Hajime");
         employee.setLastName("Moriasu");
         employee.setEmail("hajime.moriasu@bjitgroup.com");

         Mockito.when(employeeService.updateEmployeeDTO(employee,employeeId))
                 .thenReturn(Mono.just(employee));
         // when - action or behaviour that we are going test
         WebTestClient.ResponseSpec response = webClient.put()
                 .uri("/employeeDTO/{id}", Collections.singletonMap("id", employeeId))
                 .contentType(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON)
                 .body(Mono.just(employee), EmployeeDTO.class)
                 .exchange();
         // then - verify the result or output using assert statements
         response.expectStatus().isOk()
                 .expectBody()
                 .consumeWith(System.out::println);
     }
    @Test
    public void testDeleteEmployee(){
         String employeeId = "VXZ290";
         Mockito.when(employeeService.deleteEmployee(employeeId))
                 .thenReturn(Mono.empty());
        // when - action or behaviour that we are going test
        WebTestClient.ResponseSpec response = webClient.delete()
                .uri("/employee/{id}", Collections.singletonMap("id",  employeeId))
                .exchange();

        // then - verify the result or output using assert statements
        response.expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);
    }

}
