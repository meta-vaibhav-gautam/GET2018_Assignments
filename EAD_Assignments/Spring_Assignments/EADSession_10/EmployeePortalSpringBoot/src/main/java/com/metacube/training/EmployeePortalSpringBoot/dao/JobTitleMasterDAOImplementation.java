package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mapper.JobTitleMasterMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.JobTitleMaster;

/**
 * class containing implementation of interface methods
 * created on September 07, 2018
 */
@Repository
public class JobTitleMasterDAOImplementation implements JobTitleMasterDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobTitleMasterDAOImplementation(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	private final String SQL_FIND_JOB_TITLE = "SELECT job_id, job_title FROM job_title_master where job_code=?";
	private final String SQL_GET_ALL = "SELECT job_code, job_title FROM job_title_master ";
	private final String SQL_INSERT_JOB_TITLE = "insert into job_title_master (job_title) values(?)";
	
	@Override
	public JobTitleMaster getJobTitleMasterById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB_TITLE, new Object[] {id},new JobTitleMasterMapper());
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMaster() {
		return jdbcTemplate.query(SQL_GET_ALL,new JobTitleMasterMapper());
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
		return jdbcTemplate.update(SQL_INSERT_JOB_TITLE, jobTitleMaster.getJobTitle())>0;
	}

}
