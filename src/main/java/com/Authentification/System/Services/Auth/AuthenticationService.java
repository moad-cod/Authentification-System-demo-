package com.Authentification.System.Services.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Authentification.System.DTOs.Auth.LoginEmployeeDto;
import com.Authentification.System.Entity.Employee;
import com.Authentification.System.Repository.EmployeeRepository;

@Service
public class AuthenticationService {
    private final EmployeeRepository employeeRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            EmployeeRepository employeeRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
    }

    public Employee authenticate(LoginEmployeeDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()));

        return employeeRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
