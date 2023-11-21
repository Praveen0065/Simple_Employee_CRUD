package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public String saveEmployee(Employee emp) {
		emp = repo.save(emp);
		if(emp.getEmpId()!=null) {
			return "Employee Creted Successfully" + emp.getEmpId();
		}
		
		return "Employee Creation failed";
	}

	
	public List<Employee> getAll() {			
		return repo.findAll();
	}

	
	public Employee getOne(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) 
			return opt.get();
		return null;
	}


	public String updateEmp(Employee emp) {
		if(repo.existsById(emp.getEmpId())) {
			repo.save(emp);
			return "Employee Updated Successfully" + emp.getEmpId();
		}
		return "failed to update";
	}

	
	public String deleteEmp(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Employee Deleted Successfully" + id;
		}
		return "failed to delete";
	}

}
