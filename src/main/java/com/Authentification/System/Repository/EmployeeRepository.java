package com.Authentification.System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Authentification.System.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
