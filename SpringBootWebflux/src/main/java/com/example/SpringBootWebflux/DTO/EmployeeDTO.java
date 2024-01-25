package com.example.SpringBootWebflux.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class EmployeeDTO {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    //Getters and Setters
}
