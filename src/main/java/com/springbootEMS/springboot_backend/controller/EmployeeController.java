package com.springbootEMS.springboot_backend.controller;

import com.springbootEMS.springboot_backend.exception.ResourceNotFoundException;
import com.springbootEMS.springboot_backend.model.Employee;
import com.springbootEMS.springboot_backend.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee (){
        return employeeRepository.findAll();
    }


//build create employee REST API

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


// build getEmployeeById REST API

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+ id));
        return ResponseEntity.ok(employee);
    }



//    build updateEmployee REST API

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails ){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exists with id: " +id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }


//build deleteEmployee REST API
@DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById (@PathVariable long id ){
        Employee  employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exits with id :" + id));


        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
