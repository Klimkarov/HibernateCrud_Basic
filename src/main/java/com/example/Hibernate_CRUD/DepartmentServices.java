package com.example.hibernateCRUD;

import java.util.List;

public interface DepartmentServices {
	
	public List<Department> getAllDepartments();
	
	public Integer createDepartment(Department department);
	
	public String updateDepartment(Integer deptId, Department department);
	
	public String deleteDepartment(Integer deptId);
	
	public Department findDepartmentById(Integer deptId);

}