package com.metacube.training.EmployeePortalSpringBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

/**
 * Mapper class for job_details table
 * created on September 09, 2018
 */
public class JobDetailsMapper implements RowMapper<JobDetails>{

	@Override
	public JobDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setJobDetailId(rs.getInt("job_detail_Id"));
		jobDetails.setEmployeeCode(rs.getString("emp_code"));
		jobDetails.setJobCode(rs.getInt("job_code"));
		jobDetails.setReportingManager(rs.getString("reporting_mgr"));
		jobDetails.setTeamLead(rs.getString("team_lead"));
		jobDetails.setCurrentProjectId(rs.getInt("curr_Proj_Id"));
		return jobDetails;
	}
	
}
