package com.example.hibernateCRUD;

import java.util.List;

public interface EmployeeServices {
	
	public List<Employee> getAllEmployees();
	
	public Integer createEmployee(Employee employee);
	
	public String updateEmployee(Integer empId, Employee employee);
	
	public String deleteEmployee(Integer empId);
	
	//new methods
	public Employee findEmployeeById(Integer empId);
	
	public List<Employee> findEmployeeByName(String empName);
	
	public List<Employee> findEmployeesByDepartment(Integer deptId);

}
