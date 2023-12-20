package com.panagiotis.myfinalapp.service;

import com.panagiotis.myfinalapp.exceptions.EmployeeNotFoundException;
import com.panagiotis.myfinalapp.exceptions.employeeAlreadyExistsException;
import com.panagiotis.myfinalapp.model.Employee;
import com.panagiotis.myfinalapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Panagiotis Oikonomou
 */
@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeAlreadyExists(employee.getEmail())){
            throw new employeeAlreadyExistsException(employee.getEmail() + " already exists!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return employeeRepository.findById(id).map(empl ->{
            empl.setFirstname(employee.getFirstname());
            empl.setLastname(employee.getLastname());
            empl.setEmail(employee.getEmail());
            empl.setDepartment(employee.getDepartment());
            return employeeRepository.save(empl);
        }).orElseThrow(() -> new EmployeeNotFoundException("This employee could not found!"));
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException("This employee id not found: "+ id));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("This employee not found!");
        }
        employeeRepository.deleteById(id);
    }

    private boolean employeeAlreadyExists(String email) {
        return employeeRepository.findByEmail(email).isPresent();
    }
}
