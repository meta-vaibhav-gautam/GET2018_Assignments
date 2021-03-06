package com.metacube.training.EmployeePortalHibernate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalHibernate.model.JobTitleMaster;

/**
 * class for mapping resultset values with object
 * created on September 07, 2018
 */
public class JobTitleMasterMapper implements RowMapper<JobTitleMaster>{

	@Override
	public JobTitleMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobTitleMaster jobTitleMaster = new JobTitleMaster();
		jobTitleMaster.setJobCode(rs.getInt("job_code"));
		jobTitleMaster.setJobTitle(rs.getString("job_title"));
		
		return jobTitleMaster;
	}
	
}
