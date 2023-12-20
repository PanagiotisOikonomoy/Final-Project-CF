package com.panagiotis.myfinalapp.repository;

import com.panagiotis.myfinalapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Panagiotis Oikonomou
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
}
