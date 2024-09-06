package com.springbootEMS.springboot_backend;

import com.springbootEMS.springboot_backend.model.Employee;
import com.springbootEMS.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Vipul");
		employee.setLastName("Chore");
		employee.setEmailId("chorevipul2001@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Nikhil");
		employee1.setLastName("Gudadhe");
		employee1.setEmailId("nikhilgudadhe95@gmail.com");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setFirstName("Akash");
		employee2.setLastName("Newal");
		employee2.setEmailId("akashnewal99@gmail.com");
		employeeRepository.save(employee2);
	}
}
