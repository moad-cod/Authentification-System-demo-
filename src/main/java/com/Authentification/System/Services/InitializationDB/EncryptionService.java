package com.Authentification.System.Services.InitializationDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EncryptionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void encryptExistingPasswords() {
        // Get all employees with unencrypted passwords
        String selectSql = "SELECT employee_id, password FROM employee WHERE password NOT LIKE '$2a$%'";
        jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            Long id = rs.getLong("employee_id");
            String rawPassword = rs.getString("password");

            // Encrypt the password
            String encodedPassword = passwordEncoder.encode(rawPassword);

            // Update the password
            String updateSql = "UPDATE employee SET password = ? WHERE employee_id = ?";
            jdbcTemplate.update(updateSql, encodedPassword, id);

            return null;
        });
    }
}
