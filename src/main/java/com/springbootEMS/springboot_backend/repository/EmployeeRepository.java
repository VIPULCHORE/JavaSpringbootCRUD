package com.springbootEMS.springboot_backend.repository;

import com.springbootEMS.springboot_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all crud database methods
}
