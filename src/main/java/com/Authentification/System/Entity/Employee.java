package com.Authentification.System.Entity;

import jakarta.persistence.Entity;
import com.Authentification.System.DTOs.EmployeeDTO;
import com.Authentification.System.Enum.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees", schema = "springboot_schema")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private role role;

    public EmployeeDTO toDTO() {
        return new EmployeeDTO(this);
    }
}
