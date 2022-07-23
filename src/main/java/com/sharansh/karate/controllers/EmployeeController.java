package com.sharansh.karate.controllers;

import com.sharansh.karate.domain.Employee;
import com.sharansh.karate.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        log.info("Request received to fetch employee with id - " + id);
        Employee employee = employeeService.findEmployeeById(id);
        if(isNull(employee)) {
            log.info("Employee with id - " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> createPerson(@RequestBody Employee employee) {
        log.info("Creating employee with id - " + employee.getId());
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
    }
}
