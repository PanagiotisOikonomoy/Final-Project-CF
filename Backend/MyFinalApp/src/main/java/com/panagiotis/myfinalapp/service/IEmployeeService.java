package com.panagiotis.myfinalapp.service;

import com.panagiotis.myfinalapp.model.Employee;
import java.util.List;

/**
 * @author Panagiotis Oikonomou
 */
public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee updateEmployee(Employee employee,Long id);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
