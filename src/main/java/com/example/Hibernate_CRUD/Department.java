package com.example.hibernateCRUD;

public class Department {
	
	private Integer id;
	private String deptName;
	private Integer numberEmployees;
	private String projectName;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getNumberEmployees() {
		return numberEmployees;
	}
	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Department(Integer id, String deptName, Integer numberEmployees, String projectName) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.numberEmployees = numberEmployees;
		this.projectName = projectName;
	}
	
	
	
	public Department(String deptName, Integer numberEmployees, String projectName) {
		super();
		this.deptName = deptName;
		this.numberEmployees = numberEmployees;
		this.projectName = projectName;
	}
	
	public Department() {
		
	}

}
