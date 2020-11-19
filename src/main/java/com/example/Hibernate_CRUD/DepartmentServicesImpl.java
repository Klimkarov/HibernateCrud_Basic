package com.example.hibernateCRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DepartmentServicesImpl implements DepartmentServices {

	public List<Department> getAllDepartments() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Department> result = new ArrayList<Department>();

		try {
			tx = session.beginTransaction();
			List<Department> departments = session.createQuery("FROM Department").list();

			for (Department department : departments) {

				System.out.println("Dept id: " + department.getId());
				System.out.println("Department name: " + department.getDeptName());
				System.out.println("Number of employees: " + department.getNumberEmployees());
				System.out.println("Project name: " + department.getProjectName());

				result.add(department);
			}

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			session.close();
			return result;
		}

	}

	public Integer createDepartment(Department department) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(department);
			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			session.close();
			return department.getId();
		}
	}

	public String updateDepartment(Integer deptId, Department departmentNew) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			Department oldDepartment = session.get(Department.class, deptId);
			oldDepartment.setDeptName(departmentNew.getDeptName());
			oldDepartment.setNumberEmployees(departmentNew.getNumberEmployees());
			oldDepartment.setProjectName(departmentNew.getProjectName());

			session.update(oldDepartment);

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			session.close();
			return "Updated succesfully";
		}
	}

	public String deleteDepartment(Integer deptId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Department department = session.get(Department.class, deptId);
			session.delete(department);

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			session.close();
			return "Successfully deleted";
		}
	}

	public Department findDepartmentById(Integer deptId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Department department = new Department();

		try {
			tx = session.beginTransaction();
			String hql = "FROM Department d WHERE d.id=:deptid";

			Query query = session.createQuery(hql);
			List<Department> rs = query.setParameter("deptId", deptId).list();
			department = rs.get(0);

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			session.close();
			return department;
		}

	}

}
