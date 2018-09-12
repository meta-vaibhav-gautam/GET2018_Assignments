package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalHibernate.model.JobDetails;

@Repository
@Transactional
public class JobDetailsDAOImplementation implements JobDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String FIND_JobDetails = "FROM JobDetails WHERE job_detail_id = :id";
	private final String DELETE_JobDetails = "DELETE FROM JobDetails WHERE job_detail_id = :id";
	private final String UPDATE_JobDetails = "UPDATE JobDetails set "
			+ "emp_code = :employeeCode, job_code = jobCode, reporting_mgr = :reportingManager, "
			+ "team_lead = :teamLead, curr_proj_id = :currentProjectId where job_detail_id = :id";
	private final String GET_ALL = "FROM JobDetails";
	private final String FIND_JobDetailsOfEmployee = "FROM JobDetails where emp_code = :employeeCode";
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(FIND_JobDetails);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(GET_ALL);
		return query.getResultList();
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(DELETE_JobDetails);
		query.setParameter("id", jobDetails.getJobDetailId());
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(UPDATE_JobDetails);
		query.setParameter("employeeCode", jobDetails.getEmployeeCode());
		query.setParameter("jobCode", jobDetails.getJobCode());
		query.setParameter("reportingManager", jobDetails.getReportingManager());
		query.setParameter("teamLead", jobDetails.getTeamLead());
		query.setParameter("currentJobId", jobDetails.getCurrentProjectId());
		query.setParameter("id", jobDetails.getJobDetailId());
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		return ((int)sessionFactory.getCurrentSession().save(jobDetails)>0);
	}
	
	@Override
	public JobDetails getJobDetailsOfEmployee(String employeeCode) {
		JobDetails jobDetails = null;
		try {
			TypedQuery<JobDetails> query = sessionFactory.getCurrentSession().createQuery(FIND_JobDetailsOfEmployee);
			query.setParameter("employeeCode", employeeCode);
			jobDetails = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			jobDetails = new JobDetails();
			jobDetails.setEmployeeCode(employeeCode);
		}
		return jobDetails;
	}

}
