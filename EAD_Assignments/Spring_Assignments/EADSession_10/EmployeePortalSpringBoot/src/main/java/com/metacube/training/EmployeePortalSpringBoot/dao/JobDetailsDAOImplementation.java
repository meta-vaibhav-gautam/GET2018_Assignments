package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mapper.JobDetailsMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

@Repository
public class JobDetailsDAOImplementation implements JobDetailsDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobDetailsDAOImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_JobDetails = "select * from job_details where job_detail_id = ?";
	private final String SQL_DELETE_JobDetails = "delete from job_details where job_detail_id = ?";
	private final String SQL_UPDATE_JobDetails = "update job_details set emp_code = ?, job_code = ?, reporting_mgr = ?, team_lead = ?, curr_proj_id = ? where job_detail_id = ?";
	private final String SQL_GET_ALL = "select * from job_details";
	private final String SQL_INSERT_JobDetails = "insert into job_details(emp_code, job_code, reporting_mgr, team_lead, curr_proj_id) values(?,?,?,?,?)";
	private final String SQL_FIND_JobDetailsOfEmployee = "select * from job_details where emp_code = ?";
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JobDetails, new Object [] {id}, new JobDetailsMapper());
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobDetailsMapper());
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(SQL_DELETE_JobDetails, jobDetails.getJobDetailId())>0;
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(SQL_UPDATE_JobDetails,
				jobDetails.getEmployeeCode(),
				jobDetails.getJobCode(),
				jobDetails.getReportingManager(),
				jobDetails.getTeamLead(),
				jobDetails.getCurrentProjectId(),
				jobDetails.getJobDetailId()
		)>0;
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(SQL_INSERT_JobDetails,
				jobDetails.getEmployeeCode(),
				jobDetails.getJobCode(),
				jobDetails.getReportingManager(),
				jobDetails.getTeamLead(),
				jobDetails.getCurrentProjectId()
		)>0;
	}
	
	@Override
	public JobDetails getJobDetailsOfEmployee(String employeeCode) {
		JobDetails jobDetails = null;
		try {
			jobDetails = jdbcTemplate.queryForObject(SQL_FIND_JobDetailsOfEmployee, new Object[] {employeeCode}, new JobDetailsMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			jobDetails = new JobDetails();
			jobDetails.setEmployeeCode(employeeCode);
		}
		return jobDetails;
	}

}
