package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface IEmployeeService {
	

	public String saveEmployee(Employee emp);
	public List<Employee> getAll();
	public Employee getOne(Integer id);
	public String updateEmp(Employee emp);
	public String deleteEmp(Integer id);
	
	
	
	
	

}
