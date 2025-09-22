package com.Authentification.System.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Authentification.System.DTOs.EmployeeDTO;
import com.Authentification.System.Entity.Employee;
import com.Authentification.System.Repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add your service methods here
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(Employee::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(Employee::toDTO)
                .orElse(null);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);  
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee.toDTO();
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setFirstName(employeeDTO.getFirstName());
                    existingEmployee.setLastName(employeeDTO.getLastName());
                    existingEmployee.setEmail(employeeDTO.getEmail());
                    existingEmployee.setPassword(employeeDTO.getPassword());
                    existingEmployee.setRole(employeeDTO.getRole());
                    Employee updatedEmployee = employeeRepository.save(existingEmployee);
                    return updatedEmployee.toDTO();
                })
                .orElse(null);
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
