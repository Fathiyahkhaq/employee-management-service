package com.lotte.emp.controller;

import com.lotte.emp.request.EmployeeRequest;
import com.lotte.emp.response.BaseResponseTO;
import com.lotte.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<BaseResponseTO> createEmployee(@RequestBody EmployeeRequest request) {
        return ResponseEntity.status(201).body(
                BaseResponseTO.of(
                        true,
                        HttpStatus.CREATED.getReasonPhrase(),
                        employeeService.createEmployee(request))
        );
    }
    @GetMapping
    public ResponseEntity<BaseResponseTO> getAllEmployees() {
        return ResponseEntity.status(200).body(
                BaseResponseTO.of(
                        true,
                        HttpStatus.OK.getReasonPhrase(),
                        employeeService.getAllEmployees()
                )
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponseTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(
                BaseResponseTO.of(
                        true,
                        HttpStatus.OK.getReasonPhrase(),
                        employeeService.getEmployeeById(id)
                )
        );
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<BaseResponseTO> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.status(200).body(
                BaseResponseTO.of(
                        true,
                        HttpStatus.OK.getReasonPhrase(),
                        employeeService.updateEmployeeById(id, employeeRequest)
                )
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

}
