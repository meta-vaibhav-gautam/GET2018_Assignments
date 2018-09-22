package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.JobTitleMaster;

/**
 * interface containing methods for job title master
 * created on September 07, 2018
 */
public interface JobTitleMasterDAO {
	JobTitleMaster getJobTitleMasterById(int id);

	List<JobTitleMaster> getAllJobTitleMaster();

	boolean deleteJobTitleMaster(JobTitleMaster jobTitleMaster);

	boolean updateJobTitleMaster(JobTitleMaster jobTitleMaster);

	boolean createJobTitleMaster(JobTitleMaster jobTitleMaster);
}
