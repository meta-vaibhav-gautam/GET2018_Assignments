package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalHibernate.model.Employee;

/**
 * class containing implementation of interface method
 * cretaed on September 08, 2018
 */
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee getEmployeeById(String employeeCode) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("employeeCode"), employeeCode));
        Employee employee = session.createQuery(criteria).getSingleResult();
		session.close();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
	
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        List<Employee> employee = session.createQuery(criteria).getResultList();
		session.close();
		return employee;
		
	}

	@Override
	public boolean deleteEmployee(Employee employee) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaDelete<Employee> criteria = builder.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        try{
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
        return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder.createCriteriaUpdate(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        
        criteria.set(employeeRoot.get("firstName"), employee.getFirstName()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("lastName"), employee.getLastName()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("dob"), employee.getDob()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("gender"), employee.getGender()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("primaryContactNumber"), employee.getPrimaryContactNumber()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("secondaryContactNumber"), employee.getSecondaryContactNumber()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("emailID"), employee.getEmailId()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("skypeID"), employee.getSkypeId()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("profilePicture"), employee.getProfilePicture()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        criteria.set(employeeRoot.get("enabled"), employee.getEmailId()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
        
        try{
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
        return true;
	}

	@Override
	public Employee getLatestEmployeeCode() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.orderBy(builder.desc(employeeRoot.get("employeeCode")));
        Query<Employee> query = session.createQuery(criteria).setMaxResults(1);
		Employee employee = query.getSingleResult();
		session.close();
		return employee;
	}
	
}
