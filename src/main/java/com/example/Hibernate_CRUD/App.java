package com.example.hibernateCRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ParseException {
//    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
//
//		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
//
//		Session session = factory.openSession();
//
//		Transaction t = session.beginTransaction();
//		
//		session.close();

		DepartmentServices dept = new DepartmentServicesImpl();
		EmployeeServices emp = new EmployeeServicesImpl();
//
//		Department department1 = new Department(2, "Research", 5, "ProjectX");
//		Department department2 = new Department(3, "Dev", 13, "ProjectY");
//
//		Integer dept1 = dept.createDepartment(department1);
//		Integer dept2 = dept.createDepartment(department2);
//
//		System.out.println("Departments with id: " + dept1 + " and " + dept2 + "were created!");

		 dept.getAllDepartments();
//		 Department d = new Department("Dept1", 1, "DeptProj");
//		 dept.createDepartment(d);
//		 
		 Date currentTime = new Date(System.currentTimeMillis());
		 
		String date = "2020-08-16";
		Date specificdate =new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date formated = dateFormat.parse(date);
		
//		 Employee employee = new Employee("Dimitar", "Josifov", 12222, formated, d);
//		 emp.createEmployee(employee);
//		 emp.createEmployee(new Employee("Tom", "Johns", 123, formated, d));
		
//		Department d = dept.findDepartmentById(22);
//		System.out.println(d.getDeptName());
		
		List<Employee> emps = emp.findEmployeesByDepartment(22);
		System.out.println(emps.size());
		
//		Employee employee = emp.findEmployeeById(4);
//		System.out.println(employee.getId());
//		System.out.println(employee.getFirstName());
//		
//		List<Employee> emps = emp.findEmployeeByName("Dimitar");
//		System.out.println(emps.get(0).getFirstName());
		 
		 
		 
		 
		 
//		 emp.findEmployeeById(1);
		 
		 
//		Department departmentUpdated = new Department("Devops", 2, "ProjectDevOps");
//		
//		dept.updateDepartment(1, departmentUpdated);
//		
////		dept.deleteDepartment(2);		

	}
}
