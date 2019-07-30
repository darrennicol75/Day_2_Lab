package com.codeclan.example.employeeservice;

import com.codeclan.example.employeeservice.models.Department;
import com.codeclan.example.employeeservice.models.Employee;

import com.codeclan.example.employeeservice.models.Project;
import com.codeclan.example.employeeservice.repositories.DepartmentRepository;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import com.codeclan.example.employeeservice.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSaveEmployee(){
		Department marketingDept = new Department("Marketing");
		departmentRepository.save(marketingDept);

		Employee jim = new Employee("Jim", "McDonald", "123456", marketingDept);
		employeeRepository.save(jim);

		Project project1 = new Project("Marketing Campaign", 14);
		projectRepository.save(project1);

		project1.addEmployee(jim);
		projectRepository.save(project1);
	}

}
