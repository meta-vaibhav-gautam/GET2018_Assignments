package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalHibernate.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_PROJECT = "from Project where project_id = :projectId";
	private final String SQL_DELETE_PROJECT = "delete from Project where project_id = :projectId";
	private final String SQL_UPDATE_PROJECT = "update Project set description = :description, start_date  = :startDate, end_date  = :endDate where project_id = :projectId";
	private final String SQL_GET_ALL = "from Project";

	public Project getProjectById(int id) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_FIND_PROJECT);
		query.setParameter("projectId",id);
		return query.getSingleResult();
	}

	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	public boolean deleteProject(Project project) {
		TypedQuery<Project> query =  sessionFactory.getCurrentSession().createQuery(SQL_DELETE_PROJECT);
		query.setParameter("projectId", project.getId());
		return (query.executeUpdate()>0);
	}

	public boolean updateProject(Project project) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(SQL_UPDATE_PROJECT);
		query.setParameter("description",project.getDescription());
		query.setParameter("startDate",project.getStartDate());
		query.setParameter("endDate",project.getEndDate());
		query.setParameter("projectId",project.getId());
		return (query.executeUpdate()>0);
	}

	public void createProject(Project project) {
		sessionFactory.getCurrentSession().save(project);
	}


}