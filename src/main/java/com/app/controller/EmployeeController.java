package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	// save
	@PostMapping("/create")
	public String saveEmployee(@RequestBody Employee emp) {
		 return service.saveEmployee(emp);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Employee getOne(@PathVariable Integer id) {
		return service.getOne(id);
	}
	
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		return service.deleteEmp(id);
	}

}
