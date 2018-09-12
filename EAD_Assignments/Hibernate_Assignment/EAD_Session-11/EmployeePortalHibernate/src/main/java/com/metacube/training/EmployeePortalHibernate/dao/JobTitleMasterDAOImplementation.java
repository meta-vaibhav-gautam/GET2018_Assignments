package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalHibernate.model.JobTitleMaster;

/**
 * class containing implementation of interface methods
 * created on September 07, 2018
 */
@Repository
@Transactional
public class JobTitleMasterDAOImplementation implements JobTitleMasterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String FIND_JOB_TITLE = "FROM JobTitleMaster where job_code= :jobCode";
	private final String GET_ALL = "FROM JobTitleMaster";
	
	@Override
	public JobTitleMaster getJobTitleMasterById(int id) {
		TypedQuery<JobTitleMaster> query = sessionFactory.getCurrentSession().createQuery(FIND_JOB_TITLE);
		return query.getSingleResult();
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMaster() {
		TypedQuery<JobTitleMaster> query = sessionFactory.getCurrentSession().createQuery(GET_ALL);
		return query.getResultList();
	}

	@Override
	public boolean deleteJobTitleMaster(JobTitleMaster jobTitleMaster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobTitleMaster(JobTitleMaster jobTitleMaster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createJobTitleMaster(JobTitleMaster jobTitleMaster) {
		return ((int)sessionFactory.getCurrentSession().save(jobTitleMaster)>0);
	}

}
