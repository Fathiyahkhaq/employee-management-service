package com.lotte.emp.service;

import com.lotte.emp.entity.Employee;
import com.lotte.emp.repository.EmployeeRepository;
import com.lotte.emp.request.EmployeeRequest;
import com.lotte.emp.response.EmployeeTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeTO createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setPosition(request.getPosition());

        employee = employeeRepository.save(employee);

        return EmployeeTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build();
    }

    public List<EmployeeTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(
                employee -> EmployeeTO.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .email(employee.getEmail())
                        .position(employee.getPosition())
                        .salary(employee.getSalary())
                        .build()
        ).toList();
    }

    public EmployeeTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id "+id+" not found"));
        return EmployeeTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build();
    }

    public EmployeeTO updateEmployeeById(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id "+id+" not found"));
        
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setPosition(request.getPosition());
        
        employee = employeeRepository.save(employee);
        
        return EmployeeTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build();
    }

    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with id "+id+" not found");
        }
        employeeRepository.deleteById(id);
    }
}
