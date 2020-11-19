package com.example.hibernateCRUD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.FetchMode;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class EmployeeServicesImpl implements EmployeeServices {

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer createEmployee(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(employee);
			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			session.close();
			return employee.getId();
		}
	}

	public String updateEmployee(Integer empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findEmployeeById(Integer empId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Employee employee = new Employee();

		try {
			tx = session.beginTransaction();
			String hql = "FROM Employee e WHERE e.id=:empId";

			Query query = session.createQuery(hql);
			List<Employee> rs = query.setParameter("empId", empId).list();
			employee = rs.get(0);

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			session.close();
			return employee;

		}

	}

	public List<Employee> findEmployeeByName(String empName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> res = new ArrayList<Employee>();

		try {
			tx = session.beginTransaction();
			String hql = "FROM Employee e WHERE e.firstName=:empName";
			Query query = session.createQuery(hql);
			res = query.setParameter("empName", empName).list();

			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			session.close();
			return res;
		}

	}

	@SuppressWarnings("deprecation")
	public List<Employee> findEmployeesByDepartment(Integer deptId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> res = new ArrayList<Employee>();

		try {
			tx = session.beginTransaction();

			// join and join fetch
//			String hql = "SELECT e FROM Employee e JOIN e.department d WHERE d.id=:deptId";
//			Query query = session.createQuery(hql);
//			res = query.setParameter("deptId", deptId).list();

			res = session.createCriteria(Employee.class)
					.add(Restrictions.eq("department.id", deptId))
					.setFetchMode("department.id", FetchMode.EAGER)
					.list();

			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		}
		return res;
//		} finally {
//			session.close();
//			return res;
//		}
	}

}
